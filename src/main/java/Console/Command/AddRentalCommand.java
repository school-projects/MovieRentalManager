package Console.Command;

import Console.InputConverter;
import Exceptions.UserInputException;
import Model.Client;
import Model.Movie;
import Service.ClientService;
import Service.MovieService;
import Service.RentalService;

import java.util.List;

public class AddRentalCommand extends Command {
    private ClientService clientService;
    private MovieService movieService;
    private RentalService rentalService;

    public AddRentalCommand(ClientService clientService, MovieService movieService, RentalService rentalService) {
        this.clientService = clientService;
        this.movieService = movieService;
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        Client client = clientService.get(InputConverter.readInt(params.get(1))).orElseThrow(() -> new UserInputException("No client with given ID!"));
        Movie movie = movieService.get(InputConverter.readInt(params.get(2))).orElseThrow(() -> new UserInputException("No movie with given ID!"));

        rentalService.addRental(InputConverter.readInt(params.get(0)), client, movie, InputConverter.readDate(params.get(3)), InputConverter.readDate(params.get(4)));
    }

    @Override
    public Integer paramNr() {
        return 5;
    }

    @Override
    public String params() {
        return "<ID>,<CID>,<MID>,<Start>,<End>";
    }
}
