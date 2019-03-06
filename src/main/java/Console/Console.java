package Console;

import Console.Command.AddMovieCommand;
import Console.Command.Command;
import Console.Command.PrintAllMoviesCommand;
import Exceptions.RepositoryException;
import Exceptions.UserInputException;
import Service.MovieService;
import Validation.IValidator;
import Exceptions.ValidatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {

    private MovieService movieService;
  //  private IValidator<Pair<Command, List<String>>> validator;
    private List<Command> commands;

    public Console(MovieService movieService){
        this.movieService = movieService;
        //this.validator = new ParameterValidator();
        this.commands = new ArrayList<>();

        commands.add(new AddMovieCommand(movieService));
        commands.add(new PrintAllMoviesCommand(movieService));
    }

    private void executeCommand(String s) throws UserInputException{
        try {
            List<String> l = Arrays.asList(s.split(" "));
            Command cmd = commands.stream().filter(p -> p.keyword().equals(l.get(0))).collect(Collectors.toList()).get(0);

            cmd.execute(l.size()==1?  new ArrayList<>() : l.subList(1, l.size()));
        }
        catch(RepositoryException e){
            throw new UserInputException(e.getMessage());
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Insert your command: ");
            String cmd = sc.nextLine();
            try {
                if(cmd.equals("exit"))
                    break;
                executeCommand(cmd);
            }
            catch(UserInputException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
