package mars_rover.input.helpers;

import mars_rover.models.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    @DisplayName("Test parsing valid string of movement inputs without spaces.")
    void testParsingValidMovementInputWithoutSpaces() {
        LinkedList<Instruction> expectedInstructions = new LinkedList<>() {{
            add(Instruction.TurnLeft);
            add(Instruction.MoveForward);
            add(Instruction.MoveForward);
            add(Instruction.TurnRight);
            add(Instruction.TurnRight);
            add(Instruction.MoveForward);
        }};
        String movementInput = "LMMRRM";

        assertEquals(expectedInstructions, InputParser.parseInstructions(movementInput));
    }

    @Test
    @DisplayName("Test parsing valid string of movement inputs with mixed spaces.")
    void testParsingValidMovementInputWithSpaces() {
        LinkedList<Instruction> expectedInstructions = new LinkedList<>() {{
            add(Instruction.TurnLeft);
            add(Instruction.MoveForward);
            add(Instruction.MoveForward);
            add(Instruction.TurnRight);
            add(Instruction.TurnRight);
            add(Instruction.MoveForward);
        }};
        String movementInput = "L MM R   R  M";

        assertEquals(expectedInstructions, InputParser.parseInstructions(movementInput));
    }

    @Test
    @DisplayName("Test parsing valid string of movement inputs with mixed spaces and invalid characters.")
    void testParsingValidMovementInputWithSpacesAndInvalidCharacters() {
        LinkedList<Instruction> expectedInstructions = new LinkedList<>() {{
            add(Instruction.TurnLeft);
            add(Instruction.MoveForward);
            add(Instruction.MoveForward);
            add(Instruction.TurnRight);
            add(Instruction.TurnRight);
            add(Instruction.MoveForward);
        }};
        String movementInput = "L#8ggMM673nR56G6R50GM";

        assertEquals(expectedInstructions, InputParser.parseInstructions(movementInput));
    }

    @Test
    @DisplayName("Test parsing nonsense input.")
    void testParsingInvalidInput() {
        LinkedList<Instruction> expectedInstructions = new LinkedList<>();
        String movementInput = "FJGJGF)@86856";

        assertEquals(expectedInstructions, InputParser.parseInstructions(movementInput));
    }

}