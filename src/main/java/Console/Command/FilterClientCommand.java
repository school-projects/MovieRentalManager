package Console.Command;

import Service.ClientService;

import java.util.List;

public class FilterClientCommand extends Command {

    private ClientService clientService;

    public FilterClientCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute(List<String> params) {
        clientService.filterByName(params.get(0)).forEach(System.out::println);
    }

    @Override
    public Integer paramNr() {
        return 1;
    }
}
