package Console.Command;

import java.util.List;

public abstract class Command {
    public abstract void execute(List<String> params);
    public abstract String keyword();
    public abstract Integer paramNr();
}
