package Main;

import Console.Console;
import Model.Movie;
import Model.Rental;
import Repository.IRepository;
import Repository.XMLConverter.XMLClientConverter;
import Repository.XMLConverter.XMLMovieConverter;
import Repository.XMLConverter.XMLRentalConverter;
import Repository.XmlRepository;
import Service.ClientService;
import Service.MovieService;
import Service.RentalService;
import Validation.ClientValidator;
import Validation.MovieValidator;
import Validation.RentalValidator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Path filesPath = Paths.get("src", "main", "java", "Files");

        IRepository<Integer, Movie> mRepo = new XmlRepository<>(new MovieValidator(), new XMLMovieConverter(), Paths.get(filesPath.toString(), "xmlmovies.xml").toString());
        MovieService movieService = new MovieService(mRepo);
        ClientService clientService = new ClientService(new XmlRepository<>(new ClientValidator(), new XMLClientConverter(), Paths.get(filesPath.toString(), "xmlclients.xml").toString()));
        RentalService rentalService = new RentalService(new XmlRepository<>(new RentalValidator(), new XMLRentalConverter(), Paths.get(filesPath.toString(), "xmlrentals.xml").toString()), clientService, movieService);

        Console c = new Console(movieService, clientService, rentalService);
//        movieService.addMovie(1, "The Fateful Eight", LocalDate.parse("2016-01-15"));
//        movieService.addMovie(2, "Men in Black", LocalDate.parse("1997-07-04"));
//        movieService.addMovie(3, "Bohemian Rhapsody", LocalDate.parse("2018-10-24"));
//        clientService.addClient(1, "Earl", "22nd Avenue, VA");
//        clientService.addClient(2, "Anne-Marie", "23nd Avenue, VA");
//        clientService.addClient(3, "Bob", "New Hampshire, Spring Bd. #5");

        c.run();
    }
}
