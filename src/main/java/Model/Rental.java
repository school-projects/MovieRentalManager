package Model;

import java.time.LocalDate;

public class Rental extends BaseObject<Integer> {
    private int clientId;
    private int movieId;
    private LocalDate rentalStart;
    private LocalDate rentalEnd;

    public Rental(int rentalId, int clientId, int movieId, LocalDate rentalStart, LocalDate rentalEnd) {
        super(rentalId);
        this.clientId = clientId;
        this.movieId = movieId;
        this.rentalStart = rentalStart;
        this.rentalEnd = rentalEnd;
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    public LocalDate getRentalStart() {
        return this.rentalStart;
    }

    public LocalDate getRentalEnd() {
        return this.rentalEnd;
    }

    // TODO: rental duration

    public String toString() {
        return "Rental ID: " + getId() + "; Client: {" + clientId + "}; Movie: {" + movieId + "}; Rental period: " + rentalStart + " -> " + rentalEnd;
    }
}
