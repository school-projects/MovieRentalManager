package Service;

import Model.Movie;
import Repository.Repository;
import Exceptions.*;
import Validation.IValidator;
import Validation.MovieValidator;

/**
 * Service for the Movie class
 */
public class MovieService {

    private Repository<Integer, Movie> repo;
    private IValidator<Movie> validator;

    /**
     * MovieService constructor; Creates a MovieService instance with an empty repository
     */
    public MovieService() {
        this.repo = new Repository<Integer, Movie>();
        this.validator = new MovieValidator();
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
     * @param releaseDate the release date of the movie
     */
    public void addMovie(int movieId, String movieName, String releaseDate) {
        Movie newMovie = new Movie(movieId, movieName, releaseDate);
        try {
            this.validator.validate(newMovie);
            this.repo.add(newMovie);
        } catch (ValidatorException e) {
            throw new RuntimeException(e.getMessage());
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
