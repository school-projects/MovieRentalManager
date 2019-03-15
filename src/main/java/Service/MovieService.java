package Service;

import Model.Movie;
import Repository.Repository;
import Exceptions.*;
import Validation.IValidator;
import Validation.MovieValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public MovieService(Repository<Integer,Movie> repo){
        super(repo);
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

    /**
     * Filters the repository for movies that were released in a given year
     * @param year the release year
     * @return an Iterable of movies with the appropiate release date
     */
    public Iterable<Movie> filterByYear(Integer year){
        return StreamSupport.stream(repo.findAll().spliterator(), false).filter(m->m.getDate().getYear()==year).collect(Collectors.toList());
    }

    public Iterable<Movie> sortByDate(){
        return StreamSupport.stream(repo.findAll().spliterator(),false).sorted(Comparator.comparing(Model.Movie::getDate)).collect(Collectors.toList());
    }
}
