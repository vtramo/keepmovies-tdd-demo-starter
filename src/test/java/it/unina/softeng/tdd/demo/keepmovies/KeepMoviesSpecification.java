package it.unina.softeng.tdd.demo.keepmovies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.*;

import static java.util.Comparator.comparing;
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
			Collection<Movie> moviesToAdd = createAListOfMovies();

			boolean haveBeenAdded = keepMovies.addAll(moviesToAdd);

			assertThat(haveBeenAdded, is(true));
			assertThat(keepMovies.getMovies(), containsInAnyOrder(moviesToAdd.toArray()));
		}

		@Test
		@DisplayName("should not allow the same movie to be added twice")
		void shouldNotAllowTheSameMovieToBeAddedTwice() {
			Movie dunkirk 	   = new Movie("Dunkirk", Year.of(2017), "war"),
				    dunkirkClone = new Movie("Dunkirk", Year.of(2017), "war");
			keepMovies.add(dunkirk);

			boolean hasBeenAdded = keepMovies.add(dunkirkClone);

			assertThat(hasBeenAdded, is(false));
			assertThat(keepMovies.getMovies(), contains(dunkirk));
		}

		@Nested
		@DisplayName("after adding a collection of movies")
		class AfterAddingMovies {

			List<Movie> addedMovies;

			@BeforeEach
			void addMovies() {
				List<Movie> movies = createAListOfMovies();
				keepMovies.addAll(movies);
				addedMovies = movies;
			}

			@Test
			@DisplayName("should return them in lexicographic order")
			void testLexicographicOrder() {
				List<Movie> expectedMovies = new ArrayList<>(addedMovies);
				expectedMovies.sort(comparing(Movie::getTitle));

				Set<Movie> movies = keepMovies.getMovies();

				assertThat(movies, containsInRelativeOrder(expectedMovies.toArray()));
			}

			@Test
			@DisplayName("when sorting movies by year, it should return them in descending order by year")
			void testSortingByYear() {
				List<Movie> expectedMovies = new ArrayList<>(addedMovies);
				expectedMovies.sort(comparing(Movie::getReleaseYear));

				Set<Movie> movies = keepMovies.getMoviesSortedByYear();

				assertThat(movies, containsInRelativeOrder(expectedMovies.toArray()));
			}

		}

	}

	static List<Movie> createAListOfMovies() {
		return List.of(
			new Movie("Joker", Year.of(2019), "thriller"),
			new Movie("Jojo Rabbit", Year.of(2019), "comedy-drama"),
			new Movie("Dunkirk", Year.of(2017), "war"),
			new Movie("Up", Year.of(2009), "comedy-drama")
		);
	}
}