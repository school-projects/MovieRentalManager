package Console.Command;

import Service.MovieService;

import java.util.List;

public class AddMovieCommand extends Command{

    private MovieService movieService;

    public AddMovieCommand(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void execute(List<String> params) {
        movieService.addMovie(Integer.valueOf(params.get(0)),params.get(1),params.get(2));
    }

    @Override
    public String keyword() {
        return "addmovie";
    }

    @Override
    public Integer paramNr() {
        return 3;
    }


}
