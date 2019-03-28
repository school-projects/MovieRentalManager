package Console.Command;

import Console.InputConverter;
import Model.Client;
import Service.ClientService;

import java.util.List;

/**
 * Command for updating a client
 */
public class UpdateClientCommand extends Command {
    private ClientService clientService;

    public UpdateClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Executes the command
     *
     * @param params the user-given parameters
     */
    @Override
    public void execute(List<String> params) {
        Client client = new Client(InputConverter.readInt(params.get(0)), params.get(1), params.get(2));
        clientService.update(client).orElseThrow(() -> new IllegalArgumentException("invalid update! client with given id does not exist!"));
    }

    /**
     * @return 3
     */
    @Override
    public Integer paramNr() {
        return 3;
    }

    @Override
    public String params() {
        return "<ID>,<Name>,<Address>";
    }
}
