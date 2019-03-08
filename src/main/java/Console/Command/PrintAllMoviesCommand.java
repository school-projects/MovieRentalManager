package Console.Command;

import Service.MovieService;

import java.util.List;

/**
 * Command for printing all movies
 */
public class PrintAllMoviesCommand extends Command {

    private MovieService movieService;

    public PrintAllMoviesCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Executes the command
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params) {
        movieService.getAll().forEach(System.out::println);
    }

    /**
     * Returns the expected number of parameters
     * @return 0
     */
    @Override
    public Integer paramNr() {
        return 0;
    }
}
