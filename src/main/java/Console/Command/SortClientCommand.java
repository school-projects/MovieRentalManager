package Console.Command;

import Service.ClientService;

import java.util.List;

public class SortClientCommand extends Command {
    private ClientService clientService;

    public SortClientCommand(ClientService cliserv){
        this.clientService=cliserv;
    }

    @Override
    public void execute(List<String> params){
        clientService.sortAlpha().forEach(System.out::println);
    }

    @Override
    public Integer paramNr(){
        return 0;
    }
}
