package mars_rover.console.models;

import java.util.ArrayList;

public class ValidCommands {
    private ArrayList<String> commands = new ArrayList<>() {{
        add("spawn");
        add("move");
        add("quit");
    }};

    public boolean isValidCommand(String command) {
        command = command.toLowerCase();

        return this.commands.contains(command);
    }
}
