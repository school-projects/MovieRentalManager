package Console.Command;

import Model.Client;
import Service.ClientService;
import Service.RentalService;

import java.util.List;
import java.util.Map;

public class MostRentalsByClientCommand extends Command {
    private RentalService rentalService;

    public MostRentalsByClientCommand(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        // TODO: Check if repo is empty
        Map.Entry<Client, Integer> maxEntry = rentalService.mostRentalsClient();
        System.out.println("Client with most rentals was {" + maxEntry.getKey() + "}, with " + maxEntry.getValue() + " rentals");
    }

    @Override
    public Integer paramNr() {
        return 0;
    }
}
