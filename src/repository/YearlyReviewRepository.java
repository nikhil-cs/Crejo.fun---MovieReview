//$Id$
package repository;

import entity.Movie;
import valueobjects.Rating;

import java.util.*;
import java.util.stream.Collectors;

public class YearlyReviewRepository {
		

    Map<Integer, Map<Rating, List<Movie>>> yearlyRatingMap;

    public YearlyReviewRepository() {
        this.yearlyRatingMap = new HashMap<>();
    }

    public void addReview(int year, Movie movie, Rating rating) {

        Map<Rating, List<Movie>> map = yearlyRatingMap.get(year);
        if (map == null) {
            map = new TreeMap<>(new Comparator<Rating>() {
                @Override
                public int compare(Rating o1, Rating o2) {
                    return o2.compareTo(o1);
                }
            });
        }
        List<Movie> movies = map.get(rating);
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(movie);
        map.put(rating, movies);
        yearlyRatingMap.put(year, map);
    }

    public List<Movie> getTopReviews(int year, int n) {
        Map<Rating, List<Movie>> map = yearlyRatingMap.get(year);
        List<Movie> ls = new ArrayList<>(n);
        if (map == null) {
            return ls;
        }

        int index = 0;

        for (Rating r : map.keySet()) {
            List<Movie> movies = map.get(r);

            if (index + movies.size() < n) {
                ls.addAll(movies);
                index += movies.size();
            } else {
                for (Movie m : movies) {
                    if (index >= n) {
                        break;
                    }
                    ls.add(m);
                    index++;
                }
            }
            if (index >= n)
                break;

        }
        return ls;

    }
    
    public Map<Movie, Double> getTopMovieByAverage(int year) {
		 Map<Rating, List<Movie>> map = yearlyRatingMap.get(year);
		 Map<Movie,List<Rating>> movieRating = new HashMap<>();
		 Map<Movie, Double> avgRatingmap = new HashMap<>();
		 if(map == null) {
			 return avgRatingmap;
		 }
		 for(Rating r : map.keySet()) {
			 List<Movie> movies = map.get(r);
			 for(Movie m : movies) {
				 movieRating.computeIfAbsent(m, k -> new LinkedList<>()).add(r); 
			 }
		 }
		 for(Movie m : movieRating.keySet()) {
			 List<Rating> list = movieRating.get(m);
			 avgRatingmap.put(m, (list.stream().mapToInt(val -> val.getRating()).average().orElse(0.0)));
		 }
		 
		 avgRatingmap = avgRatingmap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new)); 
		 
		return avgRatingmap;
	}

}
