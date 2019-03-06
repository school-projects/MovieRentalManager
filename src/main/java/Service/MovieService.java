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
     * MovieService constructor;creates an empty repository
     */
    public MovieService(){
        this.repo = new Repository<Integer, Movie>();
        this.validator = new MovieValidator();
    }

    /**
     * MovieService constructor;creates a service with a given Movie Repository
     * @param repo is the given repository
     */

    public MovieService(Repository<Integer,Movie> repo){
        this.repo = repo;
    }

    /**
     * adds a movie to the repository
     * @param movie_id the id of the movie
     * @param movie_name the name of the movie
     * @param movie_release_date the release date of the movie
     */
    public void addMovie(int movie_id,String movie_name,String movie_release_date){
        Movie new_movie = new Movie(movie_id,movie_name,movie_release_date);
        try {
            this.validator.validate(new_movie);
            this.repo.add(new_movie);
        }catch(ValidatorException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * returns all the movies in the repository
     * @return an iterable containing all the movies
     */
    public Iterable<Movie> getAllMovies() {
        return repo.findAll();
    }
}
