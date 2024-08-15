package mars_rover.input.helpers;

import mars_rover.models.Instruction;
import mars_rover.models.InstructionMap;

import java.util.LinkedList;
import java.util.Optional;

public class InputParser {

    public static Optional<LinkedList<Instruction>> parseInstructions(String input) {
        Optional<LinkedList<Instruction>> finalInstructions = Optional.empty();
        LinkedList<Instruction> instructions = new LinkedList<>();
        char[] inputCharacters = input.toCharArray();

        for (Character c: inputCharacters) {
            Optional<Instruction> instruction = parseInstruction(c);

            if (instruction.isPresent())
                instructions.add(instruction.get());
        }

        if (!instructions.isEmpty())
            finalInstructions = Optional.of(instructions);

        return finalInstructions;
    }

    private static Optional<Instruction> parseInstruction(Character input) {
        return InstructionMap.getInstruction(input);
    }
}
