package Console.Command;

import Model.Client;
import Service.ClientService;
import Service.RentalService;

import java.util.List;

public class MostRentalsByClientCommand extends Command {
    private ClientService clientService;
    private RentalService rentalService;

    public MostRentalsByClientCommand(ClientService clientService, RentalService rentalService) {
        this.clientService = clientService;
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        // TODO: Check if repo is empty
        System.out.println(clientService.getClient(rentalService.mostRentalsClient()));
    }

    @Override
    public Integer paramNr() {
        return 0;
    }
}
