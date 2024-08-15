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
        Character searchCharacter = Character.toUpperCase(c);

        if (map.containsKey(searchCharacter)) {
            instruction = Optional.of(map.get(searchCharacter));
        }

        return instruction;
    }
}
