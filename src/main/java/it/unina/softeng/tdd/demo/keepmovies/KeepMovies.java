package it.unina.softeng.tdd.demo.keepmovies;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class KeepMovies {

  private final Set<Movie> movies = new TreeSet<>();

  public Set<Movie> getMovies() {
    return movies;
  }

  public boolean add(Movie movie) {
    return movies.add(movie);
  }

  public boolean addAll(Collection<Movie> moviesToAdd) {
    return movies.addAll(moviesToAdd);
  }

  public Set<Movie> getMoviesSortedByYear() {
    Set<Movie> sortedMovies = new TreeSet<>(
      comparing(Movie::getReleaseYear)
        .thenComparing(Movie::getTitle)
        .reversed()
    );
    sortedMovies.addAll(movies);
    return sortedMovies;
  }
}