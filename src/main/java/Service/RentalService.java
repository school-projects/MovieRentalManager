package Service;

import Model.Client;
import Model.Movie;
import Model.Rental;
import Repository.Repository;
import Validation.RentalValidator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
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

    public Map.Entry<Client, Integer> mostRentalsClient() {
        Map<Client, Integer> rentals = new HashMap<>();
        this.repo.findAll().forEach(r -> {
            if (rentals.containsKey(r.getClient()))
                rentals.put(r.getClient(), rentals.get(r.getClient()) + 1);
            else
                rentals.put(r.getClient(), 1);
        });

        return Collections.max(rentals.entrySet(), Comparator.comparing(Map.Entry::getValue));
    }

    public Map.Entry<Movie, Integer> mostRentalsMovie() {
        Map<Movie, Integer> rentals = new HashMap<>();
        this.repo.findAll().forEach(r -> {
            if (rentals.containsKey(r.getMovie()))
                rentals.put(r.getMovie(), rentals.get(r.getMovie()) + 1);
            else
                rentals.put(r.getMovie(), 1);
        });

        return Collections.max(rentals.entrySet(), Comparator.comparing(Map.Entry::getValue));
    }
}
