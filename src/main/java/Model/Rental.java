package Model;

import java.time.LocalDate;

public class Rental extends BaseObject<Integer> {
    private Client client;
    private Movie movie;
    private LocalDate rentalStart;
    private LocalDate rentalEnd;

    public Rental(int rentalId, Client client, Movie movie, LocalDate rentalStart, LocalDate rentalEnd) {
        super(rentalId);
        this.client = client;
        this.movie = movie;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
    }

    public Client getClient() {
        return this.client;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public LocalDate getRentalStart() {
        return this.rentalStart;
    }

    public LocalDate getRentalEnd() {
        return this.rentalEnd;
    }

    // TODO: rental duration

    public String toString() {
        return "Rental ID: " + getId() + "; Client: {" + client + "}; Movie: {" + movie + "}; Rental period: " + rentalStart + " -> " + rentalEnd;
    }
}
