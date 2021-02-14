//$Id$
package repository;

import entity.Movie;
import entity.User;
import valueobjects.Rating;
import valueobjects.Role;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class UserMovieRepository {

	private Map<User, Map<Movie, Rating>> userMoviesMap;

    public UserMovieRepository() {
        this.userMoviesMap = new HashMap<>();
    }

    public Map<Movie, Rating> getMoviesOfUser(User user) {
        return userMoviesMap.get(user);
    }

    public void addMovieReviewOfUser(User user, Movie movie, Rating rating) {
//        if (user.getRole() == Role.CRITICS) {
//            rating = new Rating(rating.getRating() * 2);
//        }
        Map<Movie, Rating> movieRatingMap = getMoviesOfUser(user);
        if (movieRatingMap == null) {
            movieRatingMap = new HashMap<>();
            movieRatingMap.put(movie, rating);
            userMoviesMap.put(user, movieRatingMap);
        } else if (movieRatingMap.containsKey(movie)) {
            throw new RuntimeException("User already reviewed this movie");
        } else {
            movieRatingMap.put(movie, rating);
        }
    }
    
    public Map<Movie, Integer> getTopCriticsMovies(int n){
    	Map<Movie, Integer> resultMap = new HashMap<>();
    	
    	for(User user : userMoviesMap.keySet()) {
    		if(user.getRole() == Role.CRITICS) {
    			Map<Movie, Rating> map = userMoviesMap.get(user);
    			for(Movie m : map.keySet()) {
    				int rating = map.get(m).getRating();
    				int tempRating = resultMap.getOrDefault(m, 0);
    				resultMap.put(m, rating + tempRating);
    			}
    		}
    	}
    	Object[] a = resultMap.entrySet().toArray();
    	Arrays.sort(a, new Comparator() {
    	    public int compare(Object o1, Object o2) {
    	        return ((Map.Entry<Movie, Integer>) o2).getValue()
    	                   .compareTo(((Map.Entry<Movie, Integer>) o1).getValue());
    	    }
    	});
    	
    	int index = 0;
    	for(Object o : a) {
    		Movie m = ((Map.Entry<Movie, Integer>) o).getKey();
    		Integer r = ((Map.Entry<Movie, Integer>) o).getValue();
    		System.out.println(m.getName() + " - "  + r);
    		index++;
    		if(index >= n) {
    			break;
    		}
    	}
    	
    	return resultMap;
    }
}
