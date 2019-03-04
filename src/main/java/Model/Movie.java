package Model;

public class Movie {
    private int movie_id;
    private String movie_name;
    private String release_date;//this should be YYYY-MM-DD,should change later to SimpleDateFormat

    public Movie(int mid,String mname,String reldate){
        this.movie_id=mid;
        this.movie_name=mname;
        this.release_date=reldate;
    }

    public int getMovie_id(){
        return this.movie_id;
    }
    public void setMovie_id(int mid){
        this.movie_id=mid;
    }
    public String getMovie_name(){
        return this.movie_name;
    }
    public void setMovie_name(String mname){
        this.movie_name=mname;
    }
    public String getRelease_date(){
        return this.release_date;
    }
    public void setRelease_date(String reldate){
        this.release_date=reldate;
    }
    public String toString(){
        return "Movie ID: "+this.movie_id+"; Movie Name: "+this.movie_name+"; Release Date: "+this.release_date;
    }
}
