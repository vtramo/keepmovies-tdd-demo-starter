package it.unina.softeng.tdd.demo.keepmovies;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

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
    return null;
  }
}