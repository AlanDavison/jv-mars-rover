package mars_rover.console.helpers;

import mars_rover.console.models.CommandType;
import mars_rover.console.models.ValidCommands;
import mars_rover.core.helpers.InstructionParser;
import mars_rover.core.models.Position;

import java.util.Optional;

public class CommandParser {

    public static boolean isValidCommand(String input) {
        String[] splitInput = input.split(" ");

        // We need at least two space-separated inputs here.
        if (splitInput.length < 2)
            return false;

        if (!ValidCommands.isValidCommand(splitInput[0]))
            return false;

        // Now we want to re-join the rest of our array.
        StringBuilder commandArgs = new StringBuilder();

        for (int i = 1; i < splitInput.length; i++)
            commandArgs.append(splitInput[i] + " ");

        // Now we want to attempt to determine if the command portion is valid.
        switch (getCommandType(splitInput[0])) {
            case SPAWNING -> {
                return isValidSpawnCommand(commandArgs.toString());
            }
            case MOVEMENT -> {
                return InstructionParser.parseInstructions(commandArgs.toString()).isPresent();
            }
        }

        return true;
    }

    public static boolean isValidSpawnCommand(String command) {
        // This command is fairly strict. It has to follow:
        // 0 1 N
        // Where 0 = X, 1 = Y, N = cardinal direction.

        String[] splitCommand = command.trim().split(" ");

        if (splitCommand.length != 3)
            return false;

        // Check for any invalid characters sneaking into our facing direction.
        for (Character c: splitCommand[2].toCharArray()) {
            if (!c.equals('N') && !c.equals('E') && !c.equals('S') && !c.equals('W'))
                return false;
        }


        Integer xCoord  = 0;
        Integer yCoord = 0;

        try {
            xCoord = Integer.parseInt(splitCommand[0]);
            yCoord = Integer.parseInt(splitCommand[1]);
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (xCoord < 0 || yCoord < 0)
            return false;

        return true;
    }

    public static CommandType getCommandType(String input) {
        String[] splitInput = input.split(" ");

        switch (splitInput[0]) {
            case "spawn" -> {
                return CommandType.SPAWNING;
            }
            case "move" -> {
                return CommandType.MOVEMENT;
            }
        }

        return CommandType.NONE;
    }

    public static Optional<Position> getPositionFromSpawnCommand(String command) {
        if (!isValidCommand(command))
            return Optional.empty();

        Optional<Position> position;
        String[] splitCommand = command.split(" ");

        if (splitCommand.length < 3)
            return Optional.empty();

        Integer xCoord  = 0;
        Integer yCoord = 0;

        try {
            xCoord = Integer.parseInt(splitCommand[1]);
            yCoord = Integer.parseInt(splitCommand[2]);
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }

        return Optional.of(new Position(xCoord, yCoord));
    }
}
