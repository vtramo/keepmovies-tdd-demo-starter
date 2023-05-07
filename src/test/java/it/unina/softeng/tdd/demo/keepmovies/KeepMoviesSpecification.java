package it.unina.softeng.tdd.demo.keepmovies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("A KeepMovies")
class KeepMoviesSpecification {

	KeepMovies keepMovies;

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

		@Test
		@DisplayName("should keep track of a movie")
		void shouldKeepTrackOfAMovie() {
			Movie joker = new Movie("Joker", Year.of(2019), "thriller");

			boolean hasBeenAdded = keepMovies.add(joker);

			assertThat(hasBeenAdded, is(true));
			assertThat(keepMovies.getMovies(), contains(joker));
		}

		@Test
		@DisplayName("should keep track of a set of movies")
		void shouldKeepTrackOfASetOfMovies() {
			Collection<Movie> moviesToAdd = createACollectionOfMovies();

			boolean haveBeenAdded = keepMovies.addAll(moviesToAdd);

			assertThat(haveBeenAdded, is(true));
			assertThat(keepMovies.getMovies(), containsInAnyOrder(moviesToAdd.toArray()));
		}
	}

	static Collection<Movie> createACollectionOfMovies() {
		return List.of(
			new Movie("Joker", Year.of(2019), "thriller"),
			new Movie("Jojo Rabbit", Year.of(2019), "comedy-drama"),
			new Movie("Dunkirk", Year.of(2017), "war"),
			new Movie("Up", Year.of(2009), "comedy-drama")
		);
	}
}