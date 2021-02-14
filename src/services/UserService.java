//$Id$
package services;

import entity.Movie;
import entity.User;
import repository.UserMovieRepository;
import repository.UserRepository;
import repository.YearlyReviewRepository;
import valueobjects.Rating;
import valueobjects.Role;

import java.util.Map;

public class UserService {

	    private UserRepository userRepository;
	    private UserMovieRepository userMovieRepository;
	    private YearlyReviewRepository yearlyReviewRepository;

	    public UserService() {
	        this.userRepository = new UserRepository();
	        this.userMovieRepository = new UserMovieRepository();
	        this.yearlyReviewRepository = new YearlyReviewRepository();
	    }

	    public User addUser(String name) {
	        User user = new User(name);
	        user.setRole(Role.VIEWER); //default role is Viewer
	        userRepository.addUser(user);
	        System.out.println("User " + name + " added successfully with role VIEWER");
	        return user;
	    }

	    public User getUser(String name) {
	        return userRepository.getUser(name);
	    }

	    public void addReview(User user, Movie movie, Rating rating) {
	        Map<Movie, Rating> movieRatingMap = userMovieRepository.getMoviesOfUser(user);
	        if (movieRatingMap != null) {
	            if (movieRatingMap.size() >= 3)
	                user.setRole(Role.CRITICS);
	            rating = new Rating(rating.getRating() * 2);
	        }
	        userMovieRepository.addMovieReviewOfUser(user, movie, rating);
	        yearlyReviewRepository.addReview(movie.getYear(), movie, rating);
	    }
	    
	    public void getTopCriticsMovie(int n) {
	    	 userMovieRepository.getTopCriticsMovies(n);
	    }
	    public Map<Movie, Double> getTopMovieByAverage(int year) {
			return yearlyReviewRepository.getTopMovieByAverage(year);
		}
	    
}
