package Main;

import Model.Movie;
import Repository.Repository;
import Service.ClientService;
import Service.MovieService;
import Console.Console;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        MovieService movieService = new MovieService();
        ClientService clientService = new ClientService();
        Console c = new Console(movieService, clientService);
        c.run();
//        mvsrv.addMovie(1,"The Fateful Eight","2016-01-15");
//        mvsrv.addMovie(2,"Men in Black","1997-07-04");
//        mvsrv.addMovie(3,"Bohemian Rhapsody","2018-10-24");
    }
}
