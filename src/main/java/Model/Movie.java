package Model;

public class Movie extends BaseObject<Integer>{
    private String movie_name;
    private String release_date;//this should be YYYY-MM-DD,should change later to SimpleDateFormat

    public Movie(int mid,String mname,String reldate){
        super(mid);
        this.movie_name=mname;
        this.release_date=reldate;
    }

    public int getMovie_id(){
        return this.getId();
    }

    public void setMovie_id(int mid){
        this.setId(mid);
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
        return "Movie ID: "+this.getId()+"; Movie Name: "+this.movie_name+"; Release Date: "+this.release_date;
    }
}
