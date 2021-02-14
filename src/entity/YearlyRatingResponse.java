//$Id$
package entity;

import valueobjects.Rating;
import java.util.List;

public class YearlyRatingResponse {
	
	Rating rating;
    List<Movie> movie;

    public YearlyRatingResponse(Rating rating, List<Movie> movie) {
        this.rating = rating;
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "{" +
                "" + rating +
                "=" + movie +
                '}';
    }

}
