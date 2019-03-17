package Main;

import Model.Client;
import Model.Movie;
import Repository.FileConverter.ClientFileConverter;
import Repository.FileConverter.MovieFileConverter;
import Repository.Repository;
import Repository.XMLConverter.XMLClientConverter;
import Repository.XMLConverter.XMLMovieConverter;
import Service.ClientService;
import Service.MovieService;
import Console.Console;
import Repository.FileRepository;
import Validation.ClientValidator;
import Validation.MovieValidator;
import Repository.XmlRepository;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {


        MovieService movieService = new MovieService(new XmlRepository<Integer, Movie>(new MovieValidator(),new XMLMovieConverter(),"C:\\Users\\teodo\\Desktop\\Lab2-4\\src\\main\\java\\Files\\xmlmovies.xml"));
        ClientService clientService = new ClientService(new XmlRepository<Integer, Client>(new ClientValidator(),new XMLClientConverter(),"C:\\Users\\teodo\\Desktop\\Lab2-4\\src\\main\\java\\Files\\xmlclients.xml"));
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
