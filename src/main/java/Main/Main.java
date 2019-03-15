package Main;

import Model.Client;
import Model.Movie;
import Repository.FileConverter.ClientFileConverter;
import Repository.FileConverter.MovieFileConverter;
import Repository.Repository;
import Service.ClientService;
import Service.MovieService;
import Console.Console;
import Repository.FileRepository;
import Validation.ClientValidator;
import Validation.MovieValidator;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {


        MovieService movieService = new MovieService(new FileRepository<Integer,Movie>(new MovieValidator(),new MovieFileConverter(),"C:\\Users\\teodo\\Desktop\\Lab2-4\\src\\main\\java\\Files\\movies.txt"));
        ClientService clientService = new ClientService(new FileRepository<Integer, Client>(new ClientValidator(),new ClientFileConverter(),"C:\\Users\\teodo\\Desktop\\Lab2-4\\src\\main\\java\\Files\\clients.txt"));
        Console c = new Console(movieService, clientService);
//        movieService.addMovie(1,"The Fateful Eight", LocalDate.parse("2016-01-15"));
//        movieService.addMovie(2,"Men in Black",LocalDate.parse("1997-07-04"));
//        movieService.addMovie(3,"Bohemian Rhapsody",LocalDate.parse("2018-10-24"));
//        clientService.addClient(1,"Earl","22nd Avenue, VA");
//        clientService.addClient(2,"Anne-Marie","23nd Avenue, VA");
//        clientService.addClient(3,"Bob","New Hampshire, Spring Bd. #5");
        c.run();

    }
}
