package mars_rover.console;

import mars_rover.console.helpers.CommandParser;
import mars_rover.console.helpers.ConsoleInput;
import mars_rover.console.models.ValidCommands;
import mars_rover.core.functionality.MissionControl;
import mars_rover.core.functionality.Rover;
import mars_rover.core.models.Plateau;
import mars_rover.core.models.Position;

import java.util.Optional;
import java.util.Scanner;

public class ConsoleRunner {
    ValidCommands validCommands = new ValidCommands();

    public void run() {
        MissionControl control = new MissionControl(new Plateau(10, 10));
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean quitting = false;

        while (!quitting) {
            this.printValidCommands();
            String answer = ConsoleInput.getConsoleInput(
                    "Enter a command: ",
                    "That command or syntax was invalid. Try again.",
                    scanner,
                    s -> {
                        return CommandParser.isValidCommand(s);
                    });

            // The command was valid, so we proceed to check what it actually was.

            switch (CommandParser.getCommandType(answer)) {
                case SPAWNING -> {
                    Optional<Position> position = CommandParser.getPositionFromSpawnCommand(answer);

                    if (position.isPresent()) {
                        Rover roverToAdd = new Rover(position.get());

                        if (control.addRover(roverToAdd))
                            System.out.println("Rover added successfully.");
                        else
                            System.out.println("Couldn't add Rover to this position.");
                    }
                    else
                        System.out.println("Something went wrong. Please try again.");
                }
                case MOVEMENT -> {

                }
            }
        }
    }

    public void printValidCommands() {
        System.out.println("Valid commands: ");
        this.validCommands.forEach(System.out::println);
    }
}
