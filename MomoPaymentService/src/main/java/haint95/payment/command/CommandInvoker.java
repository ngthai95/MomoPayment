package haint95.payment.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haint95
 */
public class CommandInvoker {
    private final List<CommandIF> commands = new ArrayList<>();

    public void addCommand(CommandIF command) {
        commands.add(command);
    }

    public void executeCommandsWithParams(int userId) {
        for (CommandIF command : commands) {
            command.execute(userId);
        }
        commands.clear();
    }
    public void executeCommands() {
        for (CommandIF command : commands) {
            command.execute();
        }
        commands.clear();
    }
}
