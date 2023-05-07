package it.unina.softeng.tdd.demo.keepmovies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

@DisplayName("A KeepMovies")
class KeepMoviesSpecification {

	KeepMovies keepMovies;

	void someMoviesInCaseYouNeedThem() {
		Movie joker, jojo, dunkirk, up;
		joker   = new Movie("Joker", Year.of(2019), "thriller");
		jojo    = new Movie("Jojo Rabbit", Year.of(2019), "comedy-drama");
		dunkirk = new Movie("Dunkirk", Year.of(2017), "war");
		up      = new Movie("Up", Year.of(2009), "comedy-drama");
	}

	@Nested
	@DisplayName("when instantiated")
	class whenInstantiated {

		@BeforeEach
		void createNewKeepMovies() {
			keepMovies = new KeepMovies();
		}

		@Test
		@DisplayName("should not contain any movie")
		void shouldNotContainAnyMovie() {
			Set<Movie> movies = keepMovies.getMovies();

			assertThat(movies, is(empty()));
		}
	}
}