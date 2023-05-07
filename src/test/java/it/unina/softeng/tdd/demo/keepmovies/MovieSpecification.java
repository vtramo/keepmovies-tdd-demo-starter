package it.unina.softeng.tdd.demo.keepmovies;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DisplayName("A Movie")
class MovieSpecification {

  @Test
  @DisplayName("should be marked as unwatched when instantiated")
  void shouldBeMarkedAsUnseenWhenInstantiated() {
    Movie movie = new Movie("Joker", Year.of(2019), "thriller");

    assertThat(movie.isWatched(), is(equalTo(false)));
  }
}
