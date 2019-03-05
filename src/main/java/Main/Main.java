package Main;

import Model.Movie;
import Repository.Repository;
import Service.MovieService;

import java.text.ParseException;

public class Main {
    public static void main(String args[]) throws ParseException {
        System.out.println("Hello World");
        MovieService mvsrv = new MovieService();
        mvsrv.addMovie(1,"The Fateful Eight","2016-01-15");
        mvsrv.addMovie(2,"Men in Black","1997-07-04");
        mvsrv.addMovie(3,"Bohemian Rhapsody","2018-10-24");
        mvsrv.printAllMovies();
    }
}
