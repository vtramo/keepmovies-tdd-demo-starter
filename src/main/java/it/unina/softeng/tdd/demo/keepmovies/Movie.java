package it.unina.softeng.tdd.demo.keepmovies;

import java.time.Year;
import java.util.Objects;

/**
 * Movie is a simple POJO.
 */
public class Movie implements Comparable<Movie> {
	private String title;
	private Year releaseYear;
	private String genre;
	
	public Movie(String title, Year releaseYear, String genre) {
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
	}
	
	
	/* getters and setters */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Year getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Year releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseYear=" + releaseYear + ", genre=" + genre + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return title.equals(movie.title) && releaseYear.equals(movie.releaseYear) && genre.equals(movie.genre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, releaseYear, genre);
	}

	@Override
	public int compareTo(Movie o) {
		return this.title.compareTo(o.title);
	}
}