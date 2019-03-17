package Model;

import java.time.LocalDate;


/**
 * Movie Class to be used in the rental of different movies in the Movie rental store
 */
public class Movie extends BaseObject<Integer> {
    private String movieName;
    private LocalDate releaseDate;


    public Movie(int id){super(id);}

    /**
     * Constructor for the Movie class
     *
     * @param movieId     the unique id of the movie
     * @param movieName   the movie's name
     * @param releaseDate the movie's release date
     */
    public Movie(Integer movieId, String movieName, LocalDate releaseDate) {
        super(movieId);
        this.movieName = movieName;
        this.releaseDate = releaseDate;

    }

    /**
     * Getter for the movie's name
     *
     * @return the movie's name
     */
    public String getName() {
        return this.movieName;
    }

    /**
     * Setter for the movie's name
     *
     * @param movieName the movie's new name
     */
    public void setName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * Getter for the movie's release date
     *
     * @return the movie's initial release date
     */
    public LocalDate getDate() {
        return this.releaseDate;
    }

    /**
     * Setter for the movie's release date
     *
     * @param releaseDate the movie's new release date
     */
    public void setDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * toString function of the Movie Class
     *
     * @return a string with the movie's data
     */
    public String toString() {
        return "Movie ID: " + this.getId() + "; Movie Name: " + this.movieName + "; Release Date: " + this.releaseDate;
    }
}
