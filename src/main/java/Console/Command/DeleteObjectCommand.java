package Console.Command;

import Console.InputConverter;
import Service.MovieService;
import Service.Service;

import java.util.List;

/**
 * command for deleting a movie
 */
public class DeleteObjectCommand extends Command{
    private Service service;

    public DeleteObjectCommand(Service service){
        this.service=service;
    }

    /**
     * executes the command
     *
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params){
        this.service.delete(InputConverter.readInt(params.get(0)));
    }

    /**
     * Returns the expected number of parameters
     * @return 1
     */
    @Override
    public Integer paramNr() {
        return 1;
    }
}
