package Service;

import Model.Movie;
import Repository.Repository;
import Exceptions.*;
import Validation.IValidator;
import Validation.MovieValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Service for the Movie class
 */
public class MovieService {

    private Repository<Integer, Movie> repo;

    /**
     * MovieService constructor; Creates a MovieService instance with an empty repository
     */
    public MovieService() {
        MovieValidator validator = new MovieValidator();
        this.repo = new Repository<>(validator);
    }

    /**
     * MovieService constructor; Creates a MovieService instance based on a given Movie Repository
     *
     * @param repo the given Movie repository
     */

    public MovieService(Repository<Integer, Movie> repo) {
        this.repo = repo;
    }

    /**
     * adds a movie to the repository
     *
     * @param movieId     the id of the movie
     * @param movieName   the name of the movie
     * @param releaseDate the release date of the movie in ISO-8601 date format (e.g. 2011-08-16)
     */
    public void addMovie(int movieId, String movieName, String releaseDate) {
        try {
            Movie newMovie = new Movie(movieId, movieName, LocalDate.parse(releaseDate));
            this.repo.add(newMovie);
        } catch (ValidatorException e) {
            throw new RuntimeException(e.getMessage());
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Release date is not properly formatted!");
        }
    }

    /**
     * returns all the movies in the repository
     *
     * @return an iterable containing all the movies
     */
    public Iterable<Movie> getAllMovies() {
        return repo.findAll();
    }
}
