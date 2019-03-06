package Model;

import java.text.ParseException;



/**
 * Movie Class to be used in the rental of different movies in the Movie rental store
 */
public class Movie extends BaseObject<Integer>{
    private String movie_name;
    private String release_date;

    /**
     * Constructor for the Movie class
     * @param mid the unique id of the movie
     * @param mname the movie's name
     * @param reldate the movie's release date
     */
    public Movie(int mid,String mname,String reldate){
        super(mid);
        this.movie_name=mname;
        this.release_date= reldate;

    }

    /**
     * Getter for the movie's name
     * @return the movie's name
     */
    public String getName(){
        return this.movie_name;
    }

    /**
     * Setter for the movie's name
     * @param mname the movie's new name
     */
    public void setName(String mname){
        this.movie_name=mname;
    }

    /**
     * Getter for the movie's release date
     * @return the movie's initial release date
     */
    public String getDate(){
        return this.release_date;
    }

    /**
     * Setter for the movie's release date
     * @param reldate the movie's new release date
     */
    public void setDate(String reldate){
        this.release_date=reldate;
    }

    /**
     * toString function of the Movie Class
     * @return a string with the movie's data
     */
    public String toString(){
        return "Movie ID: "+this.getId()+"; Movie Name: "+this.movie_name+"; Release Date: "+this.release_date;
    }
}
