package Console.Command;

import Service.MovieService;

import java.util.List;

public class PrintAllMoviesCommand extends Command {

    private MovieService movieService;

    public PrintAllMoviesCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void execute(List<String> params) {
        movieService.getAllMovies().forEach(System.out::println);
    }

    @Override
    public String keyword() {
        return "printallmovies";
    }

    @Override
    public Integer paramNr() {
        return 0;
    }
}
