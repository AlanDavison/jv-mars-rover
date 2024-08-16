package mars_rover.input.helpers;

import mars_rover.models.MovementInstruction;
import mars_rover.models.InstructionMap;

import java.util.LinkedList;
import java.util.Optional;

public class InputParser {

    public static Optional<LinkedList<MovementInstruction>> parseInstructions(String input) {
        Optional<LinkedList<MovementInstruction>> finalInstructions = Optional.empty();
        LinkedList<MovementInstruction> movementInstructions = new LinkedList<>();
        char[] inputCharacters = input.toCharArray();

        for (Character c: inputCharacters) {
            Optional<MovementInstruction> instruction = parseInstruction(c);

            if (instruction.isPresent())
                movementInstructions.add(instruction.get());
        }

        if (!movementInstructions.isEmpty())
            finalInstructions = Optional.of(movementInstructions);

        return finalInstructions;
    }

    private static Optional<MovementInstruction> parseInstruction(Character input) {
        return InstructionMap.getInstruction(input);
    }
}
