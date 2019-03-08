package Console.Command;

import Service.ClientService;

import java.util.List;

/**
 * Command for printing all clients
 */

public class PrintAllClientsCommand extends Command {

    private ClientService clientService;

    public PrintAllClientsCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Executes the command
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params) {
        clientService.getAllClients().forEach(System.out::println);
    }

    /**
     * Returns the expected number of parameters
     * @return 0
     */
    @Override
    public Integer paramNr() {
        return 0;
    }
}
