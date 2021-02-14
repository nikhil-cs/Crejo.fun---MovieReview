//$Id$
package entity;

import java.util.Objects;

public class Movie {

	private String name;
	private int year;

    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }


    public String getName() {
        return name;
    }
    public int getYear() {
    	return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}
