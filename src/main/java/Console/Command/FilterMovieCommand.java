package Console.Command;

import Console.InputConverter;
import Service.MovieService;

import java.util.List;

public class FilterMovieCommand extends Command{

    private MovieService movieService;

    public FilterMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }


    @Override
    public void execute(List<String> params) {
        movieService.filterByYear(InputConverter.readInt(params.get(0))).forEach(System.out::println);
    }

    @Override
    public Integer paramNr() {
        return 1;
    }
}
