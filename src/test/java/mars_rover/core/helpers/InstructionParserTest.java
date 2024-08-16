package mars_rover.core.helpers;

import mars_rover.core.models.MovementInstruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    @Test
    @DisplayName("Test parsing valid string of movement inputs without spaces.")
    void testParsingValidMovementInputWithoutSpaces() {
        LinkedList<MovementInstruction> expectedMovementInstructions = new LinkedList<>() {{
            add(MovementInstruction.TurnLeft);
            add(MovementInstruction.MoveForward);
            add(MovementInstruction.MoveForward);
            add(MovementInstruction.TurnRight);
            add(MovementInstruction.TurnRight);
            add(MovementInstruction.MoveForward);
        }};
        String movementInput = "LMMRRM";

        assertEquals(expectedMovementInstructions, InstructionParser.parseInstructions(movementInput).get());
    }

    @Test
    @DisplayName("Test parsing valid string of movement inputs with mixed spaces.")
    void testParsingValidMovementInputWithSpaces() {
        LinkedList<MovementInstruction> expectedMovementInstructions = new LinkedList<>() {{
            add(MovementInstruction.TurnLeft);
            add(MovementInstruction.MoveForward);
            add(MovementInstruction.MoveForward);
            add(MovementInstruction.TurnRight);
            add(MovementInstruction.TurnRight);
            add(MovementInstruction.MoveForward);
        }};
        String movementInput = "L MM R   R  M";

        assertEquals(expectedMovementInstructions, InstructionParser.parseInstructions(movementInput).get());
    }

    @Test
    @DisplayName("Test parsing valid string of movement inputs with mixed spaces and invalid characters.")
    void testParsingValidMovementInputWithSpacesAndInvalidCharacters() {
        LinkedList<MovementInstruction> expectedMovementInstructions = new LinkedList<>() {{
            add(MovementInstruction.TurnLeft);
            add(MovementInstruction.MoveForward);
            add(MovementInstruction.MoveForward);
            add(MovementInstruction.TurnRight);
            add(MovementInstruction.TurnRight);
            add(MovementInstruction.MoveForward);
        }};
        String movementInput = "L#8ggMM673nR56G6R50GM";

        assertEquals(expectedMovementInstructions, InstructionParser.parseInstructions(movementInput).get());
    }

    @Test
    @DisplayName("Test parsing nonsense movement input.")
    void testParsingInvalidMovementInput() {
        String movementInput = "FJGJGF)@86856";

        assertTrue(InstructionParser.parseInstructions(movementInput).isEmpty());
    }

}