package Console.Command;

import Service.MovieService;

import java.util.List;

/**
 * Command for sorting Movies after their dates
 */
public class SortMovieCommand extends Command{
    private MovieService movieService;
    public SortMovieCommand(MovieService movserv){
        this.movieService=movserv;
    }

    @Override
    public void execute(List<String> params){
        movieService.sortByDate().forEach(System.out::println);
    }

    /**
     * Returns the expected number of parameters
     * @return 0
     */
    @Override
    public Integer paramNr(){
        return 0;
    }

    @Override
    public String params() {
        return "";
    }
}
