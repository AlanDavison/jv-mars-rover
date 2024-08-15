package mars_rover.models;

import java.util.HashMap;
import java.util.Optional;

public class InstructionMap {
    private static HashMap<Character, Instruction> map = new HashMap<>() {{
        put('L', Instruction.TurnLeft);
        put('R', Instruction.TurnRight);
        put('M', Instruction.MoveForward);
    }};

    public static Optional<Instruction> getInstruction(Character c) {
        Optional<Instruction> instruction = Optional.empty();

        if (map.containsKey(c)) {
            instruction = Optional.of(map.get(c));
        }

        return instruction;
    }
}
