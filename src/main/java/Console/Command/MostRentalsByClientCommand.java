package Console.Command;

import Model.Client;
import Service.ClientService;
import Service.RentalService;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MostRentalsByClientCommand extends Command {
    private RentalService rentalService;

    public MostRentalsByClientCommand(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        try {
            Map.Entry<Client, Integer> maxEntry = rentalService.mostRentalsClient();
            System.out.println("Client with most rentals was {" + maxEntry.getKey() + "}, with " + maxEntry.getValue() + " rentals");
        } catch (NoSuchElementException e) {
            System.out.println("There are no rentals!");
        }
    }

    @Override
    public Integer paramNr() {
        return 0;
    }

    @Override
    public String params() {
        return "";
    }
}
