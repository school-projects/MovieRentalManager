package Console.Command;

import Console.InputConverter;
import Service.MovieService;

import java.util.List;

/**
 * Command for adding a movie
 */
public class AddMovieCommand extends Command {

    private MovieService movieService;

    public AddMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Executes the command
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params) {
        movieService.addMovie(InputConverter.readInt(params.get(0)), params.get(1), InputConverter.readDate(params.get(2)));
    }

    /**
     * Returns the expected number of parameters
     * @return 3
     */
    @Override
    public Integer paramNr() {
        return 3;
    }

    @Override
    public String params() {
        return "<ID>,<Name>,<ReleaseDate>";
    }


}
