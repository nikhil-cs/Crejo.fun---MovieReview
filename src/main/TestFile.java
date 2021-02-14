//$Id$
package main;

import repository.UserMovieRepository;
import services.MovieService;
import services.UserService;
import valueobjects.Rating;

public class TestFile {

	private UserService userService;
    private MovieService movieService;


    public TestFile() {
        this.movieService = new MovieService();
        this.userService = new UserService();
    }

    public void addMovie() {
        movieService.addMovie("Don", 2006);
        movieService.addMovie("Tiger", 2008);
        movieService.addMovie("Padmaavat", 2006);
        movieService.addMovie("Lunchbox", 2021);
        movieService.addMovie("Guru", 2006);
        movieService.addMovie("Metro", 2006);
    }

    public void addUser() {
        userService.addUser("SRK");
        userService.addUser("Salman");
        userService.addUser("Deepika");
    }

    public void addReviews() {

        userService.addReview(userService.getUser("SRK"), movieService.getMovie("Don"), new Rating(2));
        userService.addReview(userService.getUser("SRK"), movieService.getMovie("Padmaavat"), new Rating(5));
        userService.addReview(userService.getUser("Salman"), movieService.getMovie("Don"), new Rating(5));
        userService.addReview(userService.getUser("Deepika"), movieService.getMovie("Don"), new Rating(9));
        userService.addReview(userService.getUser("Deepika"), movieService.getMovie("Guru"), new Rating(6));
        try {
            userService.addReview(userService.getUser("SRK"), movieService.getMovie("Don"), new Rating(10));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        userService.addReview(userService.getUser("Deepika"), movieService.getMovie("Lunchbox"), new Rating(5));

        userService.addReview(userService.getUser("SRK"), movieService.getMovie("Tiger"), new Rating(5));
        userService.addReview(userService.getUser("SRK"), movieService.getMovie("Metro"), new Rating(7));


    }

    public void topInYear(){
        System.out.println(movieService.getTopMovies(2006, 1));
        //Critics
        userService.getTopCriticsMovie(1);
        
    }
    
    public void getTopMovieByAverage() {
    	System.out.println(userService.getTopMovieByAverage(2006));
    }
}
