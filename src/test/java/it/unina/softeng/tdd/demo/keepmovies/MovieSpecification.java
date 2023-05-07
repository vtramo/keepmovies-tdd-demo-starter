package it.unina.softeng.tdd.demo.keepmovies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("A Movie")
class MovieSpecification {

  Movie movie;

  @Nested
  @DisplayName("when instantiated")
  class whenInstantiated {

    @BeforeEach
    void createMovie() {
      movie = new Movie("Joker", Year.of(2019), "thriller");
    }

    @Test
    @DisplayName("should be marked as unwatched")
    void shouldBeMarkedAsUnwatched() {
      assertThat(movie.isWatched(), is(equalTo(false)));
    }


    @Test
    @DisplayName("when set as watched should be marked as already watched")
    void shouldBeMarkedAsWatchedWhenSetAsWatched() {
      movie.setWatched(true);

      assertThat(movie.isWatched(), is(equalTo(true)));
    }
  }
}