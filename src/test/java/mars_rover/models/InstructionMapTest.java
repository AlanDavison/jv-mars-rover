package mars_rover.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InstructionMapTest {

    @Test
    @DisplayName("Test pulling correct Instruction from InstructionMap.")
    void testGettingCorrectInstructionFromMap() {
        Optional<Instruction> expected = Optional.of(Instruction.TurnRight);
        Character input = 'R';
        assertEquals(expected, InstructionMap.getInstruction(input));

        expected = Optional.of(Instruction.TurnLeft);
        input = 'L';
        assertEquals(expected, InstructionMap.getInstruction(input));

        expected = Optional.of(Instruction.MoveForward);
        input = 'M';
        assertEquals(expected, InstructionMap.getInstruction(input));
    }

    @Test
    @DisplayName("Test pulling correct Instruction from InstructionMap with lowercase commands.")
    void testGettingCorrectInstructionFromMapWithLowercaseInput() {
        Optional<Instruction> expected = Optional.of(Instruction.TurnRight);
        Character input = 'r';
        assertEquals(expected, InstructionMap.getInstruction(input));

        expected = Optional.of(Instruction.TurnLeft);
        input = 'l';
        assertEquals(expected, InstructionMap.getInstruction(input));

        expected = Optional.of(Instruction.MoveForward);
        input = 'm';
        assertEquals(expected, InstructionMap.getInstruction(input));
    }

    @Test
    @DisplayName("Test trying to pull Instruction from InstructionMap with invalid input.")
    void testInvalidInputToGetInstruction() {
        Optional<Instruction> expected = Optional.empty();
        Character input = 'H';
        assertEquals(expected, InstructionMap.getInstruction(input));

        input = 'Q';
        assertEquals(expected, InstructionMap.getInstruction(input));
    }

}