package Service;

import Exceptions.ValidatorException;
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
import java.util.stream.StreamSupport;

public class RentalService extends Service<Integer, Rental> {
    private ClientService clientService;
    private MovieService movieService;

    public RentalService() {
        super(new RentalValidator());
    }

    public RentalService(Repository<Integer, Rental> repo, ClientService clientService, MovieService movieService) {
        super(repo);
        this.clientService = clientService;
        this.movieService = movieService;
    }

    public void addRental(int rentalId, Client client, Movie movie, LocalDate rentalStart, LocalDate rentalEnd) {
        Rental newRental = new Rental(rentalId, client.getId(), movie.getId(), rentalStart, rentalEnd);
        repo.findAll().forEach(r->{if(r.getClientId()==newRental.getClientId() && r.getMovieId() == newRental.getMovieId() &&
                ((r.getRentalStart().isBefore(newRental.getRentalStart()) && r.getRentalEnd().isAfter(newRental.getRentalEnd())) || (r.getRentalStart().isAfter(newRental.getRentalStart()) && r.getRentalEnd().isBefore(newRental.getRentalEnd())) ))
            throw new ValidatorException("That client is already renting that movie!");});
        super.add(newRental);
    }

    public Map.Entry<Client, Integer> mostRentalsClient() {
        Map<Client, Integer> rentals = new HashMap<>();
        this.repo.findAll().forEach(r -> {
            Client client = clientService.get(r.getClientId()).orElseThrow(() -> new RuntimeException("Client no longer exists!"));
            if (rentals.containsKey(client))
                rentals.put(client, rentals.get(client) + 1);
            else
                rentals.put(client, 1);
        });

        return Collections.max(rentals.entrySet(), Comparator.comparing(Map.Entry::getValue));
    }

    public Map.Entry<Movie, Integer> mostRentalsMovie() {
        Map<Movie, Integer> rentals = new HashMap<>();
        this.repo.findAll().forEach(r -> {
            Movie movie = movieService.get(r.getMovieId()).orElseThrow(() -> new RuntimeException("Movie no longer exists!"));
            if (rentals.containsKey(movie))
                rentals.put(movie, rentals.get(movie) + 1);
            else
                rentals.put(movie, 1);
        });

        return Collections.max(rentals.entrySet(), Comparator.comparing(Map.Entry::getValue));
    }
}
