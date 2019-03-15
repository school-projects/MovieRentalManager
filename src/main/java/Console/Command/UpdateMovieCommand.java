package Console.Command;

import Console.InputConverter;
import Model.Movie;
import Service.MovieService;
import jdk.internal.util.xml.impl.Input;

import java.util.List;

public class UpdateMovieCommand extends Command {
    private MovieService movieService;

    public UpdateMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void execute(List<String> params) {
        Movie movie = new Movie(InputConverter.readInt(params.get(0)), params.get(1), InputConverter.readDate(params.get(2)));
        movieService.update(movie);
    }

    @Override
    public Integer paramNr() {
        return 3;
    }
}
