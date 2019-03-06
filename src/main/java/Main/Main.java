package Main;

import Model.Movie;
import Repository.Repository;
import Service.MovieService;
import Console.Console;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        MovieService mvsrv = new MovieService();
        Console c = new Console(mvsrv);
        c.run();
//        mvsrv.addMovie(1,"The Fateful Eight","2016-01-15");
//        mvsrv.addMovie(2,"Men in Black","1997-07-04");
//        mvsrv.addMovie(3,"Bohemian Rhapsody","2018-10-24");
    }
}
