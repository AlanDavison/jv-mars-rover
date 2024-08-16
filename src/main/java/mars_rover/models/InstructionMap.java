package mars_rover.models;

import java.util.HashMap;
import java.util.Optional;

public class InstructionMap {
    private static HashMap<Character, MovementInstruction> map = new HashMap<>() {{
        put('L', MovementInstruction.TurnLeft);
        put('R', MovementInstruction.TurnRight);
        put('M', MovementInstruction.MoveForward);
    }};

    public static Optional<MovementInstruction> getInstruction(Character c) {
        Optional<MovementInstruction> instruction = Optional.empty();
        Character searchCharacter = Character.toUpperCase(c);

        if (map.containsKey(searchCharacter)) {
            instruction = Optional.of(map.get(searchCharacter));
        }

        return instruction;
    }
}
