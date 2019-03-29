package Console.Command;

import Console.InputConverter;
import Service.Service;

import java.util.List;
import java.util.Scanner;

public class PagePrintCommand extends Command {

    private Service service;

    public PagePrintCommand(Service service) {
        this.service = service;
    }

    private void printPage(){
        service.getNextPage().getContent().forEach(System.out::println);
    }

    @Override
    public void execute(List<String> params) {
        service.setPageSize(InputConverter.readInt(params.get(0)));
        Scanner sc = new Scanner(System.in);
        boolean w = true;
        printPage();
        while(w){
            System.out.print("N - next page, X - stop: ");
            switch (sc.nextLine()){
                case "N":
                    printPage();
                    continue;
                case "X":
                    service.resetPage();
                    w=false;
                    break;
                default:
                    System.out.println("Command not recognised!");
                    break;

            }
        }
    }

    @Override
    public Integer paramNr() {
        return 1;
    }

    @Override
    public String params() {
        return "<PageSize>";
    }
}
