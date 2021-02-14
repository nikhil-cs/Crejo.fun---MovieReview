//$Id$
package main;

public class Main {

	 public static void main(String[] args) {

	        TestFile file = new TestFile();
	        file.addMovie();
	        file.addUser();
	        file.addReviews();
	        file.topInYear();
	        file.getTopMovieByAverage();
	    }
}
