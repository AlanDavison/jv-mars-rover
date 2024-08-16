package mars_rover.console.models;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ValidCommands {
    private static ArrayList<String> commands = new ArrayList<>() {{
        add("spawn");
        add("move");
        add("quit");
    }};

    public static boolean isValidCommand(String command) {
        command = command.toLowerCase();

        return commands.contains(command);
    }

    public static void forEach(Consumer<String> consumer) {
        commands.forEach(consumer);
    }
}
