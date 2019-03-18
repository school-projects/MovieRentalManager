package Console.Command;

import Service.MovieService;
import Service.RentalService;

import java.util.List;

public class MostRentedMovieCommand extends Command {
    private MovieService movieService;
    private RentalService rentalService;

    public MostRentedMovieCommand(MovieService movieService, RentalService rentalService) {
        this.movieService = movieService;
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        System.out.println(movieService.getMovie(rentalService.mostRentalsMovie()));
    }

    @Override
    public Integer paramNr() {
        return 0;
    }
}
