package mars_rover.console;

import mars_rover.console.helpers.CommandParser;
import mars_rover.console.helpers.ConsoleInput;
import mars_rover.console.models.ValidCommands;
import mars_rover.core.functionality.MissionControl;
import mars_rover.core.functionality.Rover;
import mars_rover.core.helpers.InstructionParser;
import mars_rover.core.models.MovementInstruction;
import mars_rover.core.models.Orientation;
import mars_rover.core.models.Plateau;
import mars_rover.core.models.Position;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleRunner {
    ValidCommands validCommands = new ValidCommands();
    MissionControl control = null;

    private static boolean testForCorrectPlateauSizeCommand(String scannerInput) {
        String[] splitInput = scannerInput.split(" ");

        if (splitInput.length != 2)
            return false;

        Integer xCoord = 0;
        Integer yCoord = 0;

        try {
            xCoord = Integer.parseInt(splitInput[0]);
            yCoord = Integer.parseInt(splitInput[1]);
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (xCoord < 0 || yCoord < 0)
            return false;

        return true;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean quitting = false;

        do {
            System.out.println("Enter a size for the plateau:");
            String plateauSizeCommand = ConsoleInput.getConsoleInput(
                    "Size: ",
                    "That format was invalid. Must be in the form of \"0 0\"",
                    scanner,
                    ConsoleRunner::testForCorrectPlateauSizeCommand
            );

            // The input is validated, so we know it's safe.
            String[] plateauSizeString = plateauSizeCommand.split(" ");
            int width = Integer.parseInt(plateauSizeString[0]);
            int height = Integer.parseInt(plateauSizeString[1]);

            this.control = new MissionControl(new Plateau(width, height));
        } while (this.control == null);

        while (!quitting) {
            System.out.println("Now enter the rover's spawn command (0 0 [N|E|S|W]).");
            String roverSpawn = ConsoleInput.getConsoleInput(
                    "Command: ",
                    "That format was invalid. Must be in the form of \"0 0 [N|E|S|W]\"",
                    scanner,
                    CommandParser::isValidSpawnCommand
            );

            Position position = CommandParser.getPositionFromSpawnCommand(roverSpawn).get();
            int orientationIndex = 0;

            switch (roverSpawn.split(" ")[2]) {
                case "N" -> orientationIndex = 0;
                case "E" -> orientationIndex = 1;
                case "S" -> orientationIndex = 2;
                case "W" -> orientationIndex = 3;
            }

            Rover rover = new Rover(position, orientationIndex);
            if (control.addRover(rover)) {
                System.out.println("Rover added successfully!");
                control.printRoverDetail(control.getCurrentRover().get());
            }
            else {
                System.out.println("The Rover couldn't be added there.");
                continue;
            }

            System.out.println("Enter a move command: (consisting of L, R, and M)");
            String moveCommand = ConsoleInput.getConsoleInput(
                    "Command: ",
                    "That didn't look quite right. Try again!",
                    scanner,
                    s -> {
                        Optional<LinkedList<MovementInstruction>> instructions = InstructionParser.parseInstructions(s);

                        return instructions.isPresent();
                    }
            );

            Optional<LinkedList<MovementInstruction>> instructions = InstructionParser.parseInstructions(moveCommand);

            for (var instruction: instructions.get()) {
                if (!control.getCurrentRover().isPresent())
                    continue;

                control.receiveInstruction(control.getCurrentRover().get(), instruction);
            }

            control.printRoverDetail(control.getCurrentRover().get());
        }
    }
}
