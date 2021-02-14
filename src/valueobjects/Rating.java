//$Id$
package valueobjects;

public class Rating implements Comparable<Rating> {

    private int rating;

    public Rating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public int compareTo(Rating o) {
        return this.getRating() - o.getRating();
    }

    @Override
    public String toString() {
        return "{" +
                "rating=" + rating +
                '}';
    }
}
