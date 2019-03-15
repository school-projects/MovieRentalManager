package Console.Command;

import Console.InputConverter;
import Model.Client;
import Service.ClientService;

import java.util.List;

public class UpdateClientCommand extends Command {
    private ClientService clientService;

    public UpdateClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(List<String> params) {
        Client client = new Client(InputConverter.readInt(params.get(0)), params.get(1), params.get(2));
        clientService.update(client);
    }

    @Override
    public Integer paramNr() {
        return 3;
    }
}
