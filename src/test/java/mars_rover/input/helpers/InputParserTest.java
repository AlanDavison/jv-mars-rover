package mars_rover.input.helpers;

import mars_rover.models.MovementInstruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

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

        assertEquals(expectedMovementInstructions, InputParser.parseInstructions(movementInput).get());
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

        assertEquals(expectedMovementInstructions, InputParser.parseInstructions(movementInput).get());
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

        assertEquals(expectedMovementInstructions, InputParser.parseInstructions(movementInput).get());
    }

    @Test
    @DisplayName("Test parsing nonsense movement input.")
    void testParsingInvalidMovementInput() {
        String movementInput = "FJGJGF)@86856";

        assertTrue(InputParser.parseInstructions(movementInput).isEmpty());
    }

}