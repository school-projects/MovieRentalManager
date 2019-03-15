package Console.Command;

import Console.InputConverter;
import Model.Movie;
import Service.MovieService;

import java.util.List;

/**
 * Command for updating a movie
 */
public class UpdateMovieCommand extends Command {
    private MovieService movieService;

    public UpdateMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Executes the command
     *
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params) {
        Movie movie = new Movie(InputConverter.readInt(params.get(0)), params.get(1), InputConverter.readDate(params.get(2)));
        movieService.update(movie);
    }

    /**
     * @return 3
     */
    @Override
    public Integer paramNr() {
        return 3;
    }
}
