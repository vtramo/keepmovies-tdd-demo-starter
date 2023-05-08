package it.unina.softeng.tdd.demo.keepmovies;

import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class KeepMovies {

  private Set<Movie> movies = new TreeSet<>();

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
    Set<Movie> sortedMovies = new TreeSet<>(Movie.comparingByYearThenComparingByTitleReversed);
    sortedMovies.addAll(movies);
    return sortedMovies;
  }

  public Set<Movie> getWatchedMovies() {
    return movies.stream()
      .filter(Movie::isWatched)
      .collect(toSet());
  }

  public Set<Movie> markAsWatched(Movie ... movies) {
    Arrays.stream(movies).forEach(movie -> {
      if (!this.movies.contains(movie))
        throw new IllegalArgumentException("The " + movie + " does not exist!");
    });

    return Arrays.stream(movies)
      .peek(movie -> movie.setWatched(true))
      .collect(toSet());
  }

  public Set<Movie> deleteWatchedMovies() {
    Set<Movie> deletedWatchedMovies = new HashSet<>();

    this.movies = movies.stream()
      .peek(movie -> { if (movie.isWatched()) deletedWatchedMovies.add(movie); })
      .filter(Predicate.not(Movie::isWatched))
      .collect(toSet());

    return deletedWatchedMovies;
  }
}