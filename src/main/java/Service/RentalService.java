package Service;

import Model.Client;
import Model.Movie;
import Model.Rental;
import Repository.Repository;
import Validation.RentalValidator;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

    public int mostRentalsClient() {
        Map<Integer, Integer> rentals = new HashMap<>();
        this.repo.findAll().forEach(r -> {
            int clientId = r.getClient().getId();
            if (rentals.containsKey(clientId))
                rentals.put(clientId, rentals.get(clientId) + 1);
            else
                rentals.put(clientId, 1);
        });

        Map.Entry<Integer, Integer> maxEntry = Collections.max(rentals.entrySet(), (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
        return maxEntry.getValue();
    }

    public int mostRentalsMovie() {
        Map<Integer, Integer> rentals = new HashMap<>();
        this.repo.findAll().forEach(r -> {
            int movieId = r.getMovie().getId();
            if (rentals.containsKey(movieId))
                rentals.put(movieId, rentals.get(movieId) + 1);
            else
                rentals.put(movieId, 1);
        });

        Map.Entry<Integer, Integer> maxEntry = Collections.max(rentals.entrySet(), (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
        return maxEntry.getValue();
    }
}
