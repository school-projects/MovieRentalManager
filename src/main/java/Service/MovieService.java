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
public class MovieService extends Service<Integer, Movie> {
    /**
     * Creates a MovieService instance with an empty repository
     */
    public MovieService() {
        super(new MovieValidator());
    }


    /**
     * Adds a movie to the repository
     *
     * @param movieId     the id of the movie
     * @param movieName   the name of the movie
     * @param releaseDate the release date of the movie in ISO-8601 date format (e.g. 2011-08-16)
     */
    public void addMovie(int movieId, String movieName, LocalDate releaseDate) {
        Movie newMovie = new Movie(movieId, movieName, releaseDate);
        super.add(newMovie);
    }
}
