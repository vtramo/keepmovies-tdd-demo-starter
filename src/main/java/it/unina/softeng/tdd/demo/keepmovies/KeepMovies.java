package it.unina.softeng.tdd.demo.keepmovies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class KeepMovies {

  private final Set<Movie> movies = new HashSet<>();

  public Set<Movie> getMovies() {
    return movies;
  }

  public boolean add(Movie movie) {
    return movies.add(movie);
  }

  public boolean addAll(Collection<Movie> moviesToAdd) {
    return movies.addAll(moviesToAdd);
  }
}