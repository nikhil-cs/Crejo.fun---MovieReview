//$Id$
package repository;

import entity.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRepository {
	
	private Map<String, Movie> moviesMap;

    public MovieRepository() {
        this.moviesMap = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        this.moviesMap.put(movie.getName(), movie);
    }

    public void updateMovie(Movie movie) {
        this.moviesMap.put(movie.getName(), movie);
    }

    public Movie getMovie(String movieName) {
        return moviesMap.get(movieName);
    }
}
