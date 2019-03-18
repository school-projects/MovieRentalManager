package Console;

import Console.Command.*;
import Exceptions.UserInputException;
import Exceptions.ValidatorException;
import Service.ClientService;
import Service.MovieService;
import Service.RentalService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The main class for the console-based UI
 */
public class Console {

    private Map<String, Command> commands;

    public Console(MovieService movieService, ClientService clientService, RentalService rentalService) {
        this.commands = new HashMap<>();

        commands.put("addmovie", new AddMovieCommand(movieService));
        commands.put("printallmovies", new PrintAllMoviesCommand(movieService));
        commands.put("addclient", new AddClientCommand(clientService));
        commands.put("printallclients", new PrintAllClientsCommand(clientService));
        commands.put("sortclients", new SortClientCommand(clientService));
        commands.put("deletemovie", new DeleteObjectCommand(movieService));
        commands.put("deleteclient", new DeleteObjectCommand(clientService));
        commands.put("updatemovie", new UpdateMovieCommand(movieService));
        commands.put("updateclient", new UpdateClientCommand(clientService));
        commands.put("filterclientname", new FilterClientCommand(clientService));
        commands.put("filtermovieyear", new FilterMovieCommand(movieService));
        commands.put("sortmovies", new SortMovieCommand(movieService));
        commands.put("addrental", new AddRentalCommand(clientService, movieService, rentalService));
        commands.put("printallrentals", new PrintAllRentalsCommand(rentalService));
        commands.put("mostrentalsclient", new MostRentalsByClientCommand(rentalService));
        commands.put("mostrentalsmovie", new MostRentedMovieCommand(rentalService));
    }

    /**
     * Takes the user input and executes the command corresponding to it
     *
     * @param s the user input
     * @throws UserInputException if the user issues an invalid command(wrong keyword, wrong parameters)
     */
    private void executeCommand(String s) throws UserInputException {

        Optional<Command> cmd;
        List<String> l = Arrays.asList(s.split(" ", 2));

        try {
            cmd = Optional.of(commands.get(l.get(0)));
        } catch (NullPointerException e) {
            throw new UserInputException("Command not recognised!");
        }

        List<String> params = l.size() == 1 ? new ArrayList<>() : Arrays.asList(l.get(1).split(","));
        params = params.stream().map(String::trim).collect(Collectors.toList());

        if (params.size() != cmd.get().paramNr())
            throw new UserInputException("Invalid number of parameters!");

        try {
            cmd.get().execute(params);
        } catch (ValidatorException e) {
            throw new UserInputException(e.getMessage());
        }


    }

    /**
     * Starts the console-based UI
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Insert your command: ");
            String cmd = sc.nextLine();
            try {
                if (cmd.equals("exit"))
                    break;

                if (cmd.equals("help")) {
                    commands.keySet().forEach(System.out::println);
                    continue;
                }

                executeCommand(cmd);
            } catch (UserInputException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
