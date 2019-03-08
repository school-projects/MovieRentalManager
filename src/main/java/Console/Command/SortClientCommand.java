package Console.Command;

import Service.ClientService;

import java.util.List;

/**
 * Command for sorting the clients alphabetically after their names
 */
public class SortClientCommand extends Command {
    private ClientService clientService;

    public SortClientCommand(ClientService cliserv){
        this.clientService=cliserv;
    }

    /**
     * Executes the command
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params){
        clientService.sortAlpha().forEach(System.out::println);
    }

    /**
     * Returns the expected number of parameters
     * @return 0
     */
    @Override
    public Integer paramNr(){
        return 0;
    }
}
