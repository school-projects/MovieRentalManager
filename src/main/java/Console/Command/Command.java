package Console.Command;

import java.util.List;

/**
 * Abstract class that represents a command that the user can issue
 */
public abstract class Command {
    /**
     * Executes the command
     * @param params the user-given parameters
     */
    public abstract void execute(List<String> params);

    /**
     * Returns the expected number of parameters
     * @return the expected number of parameters
     */
    public abstract Integer paramNr();
}
