package Service;

import Model.Client;
import Model.Movie;
import Model.Rental;
import Repository.Repository;
import Validation.RentalValidator;

import java.time.LocalDate;

public class RentalService extends Service<Integer, Rental> {
    public RentalService() {
        super(new RentalValidator());
    }

    public RentalService(Repository<Integer, Rental> repo) {
        super(repo);
    }

    public void addRental(int rentalId, Client client, Movie movie, LocalDate rentalStart, LocalDate rentalEnd) {
        Rental newRental = new Rental(rentalId, client, movie, rentalStart, rentalEnd);
        super.add(newRental);
    }
}
