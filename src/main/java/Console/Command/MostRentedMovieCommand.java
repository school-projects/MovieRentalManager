package Console.Command;

import Model.Movie;
import Service.RentalService;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MostRentedMovieCommand extends Command {
    private RentalService rentalService;

    public MostRentedMovieCommand(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        try {
            Map.Entry<Movie, Integer> maxEntry = rentalService.mostRentalsMovie();
            System.out.println("Most rented movie was {" + maxEntry.getKey() + "}, with " + maxEntry.getValue() + " rentals");
        } catch (NoSuchElementException e) {
            System.out.println("There are no rentals!");
        }
    }

    @Override
    public Integer paramNr() {
        return 0;
    }
}
