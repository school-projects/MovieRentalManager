package Console.Command;

import Console.InputConverter;
import Service.ClientService;

import java.util.List;

/**
 * Command for adding a client
 */
public class AddClientCommand extends Command {

    private ClientService clientService;

    public AddClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Executes the command
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params) {
        clientService.addClient(InputConverter.readInt(params.get(0)), params.get(1), params.get(2));
    }

    /**
     * Returns the expected number of parameters
     * @return 3
     */
    @Override
    public Integer paramNr() {
        return 3;
    }
}
