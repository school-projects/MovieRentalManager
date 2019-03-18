package Console.Command;

import Service.RentalService;

import java.util.List;

public class PrintAllRentalsCommand extends Command {
    private RentalService rentalService;

    public PrintAllRentalsCommand(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @Override
    public void execute(List<String> params) {
        rentalService.getAll().forEach(System.out::println);
    }

    @Override
    public Integer paramNr() {
        return 0;
    }
}
