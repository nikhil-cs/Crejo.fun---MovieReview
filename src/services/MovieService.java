//$Id$
package services;

import entity.Movie;
import repository.MovieRepository;
import repository.YearlyReviewRepository;
import valueobjects.Rating;

import java.util.List;
import java.util.*;

public class MovieService {
	
	 private MovieRepository movieRepository;
	    private YearlyReviewRepository yearlyReviewRepository;

	    public MovieService() {
	        this.movieRepository = new MovieRepository();
	        this.yearlyReviewRepository = new YearlyReviewRepository();
	    }

	    public Movie addMovie(String movieName, int year) {
	        Movie movie = new Movie(movieName,year);
	        movieRepository.addMovie(movie);
	        yearlyReviewRepository.addReview(year, movie, new Rating(0));
	        System.out.println("Movie " + movieName + " added successfully");
	        return movie;
	    }

	    public Movie getMovie(String name) {
	        return movieRepository.getMovie(name);
	    }

	    public List<Movie> getTopMovies(int year, int n) {
	        return yearlyReviewRepository.getTopReviews(year, n);
	    }
	    

}
