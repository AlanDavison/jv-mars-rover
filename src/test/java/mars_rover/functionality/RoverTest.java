package mars_rover.functionality;

import mars_rover.models.Instruction;
import mars_rover.models.Orientation;
import mars_rover.models.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Test Rover rotation instructions.")
    void testReceiveRotationInstructions() {
        Rover rover = new Rover(new Position(4, 6));

        rover.receiveInstruction(Instruction.TurnLeft);
        assertEquals(Orientation.WEST, rover.getOrientation());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.NORTH, rover.getOrientation());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.EAST, rover.getOrientation());
    }

    @Test
    @DisplayName("Test giving a Rover all types of instructions and check if it obeys correctly.")
    void testReceiveMixedInstruction() {
        Rover rover = new Rover(new Position(4, 6));

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 7), rover.getPosition());

        rover.receiveInstruction(Instruction.TurnLeft);
        assertEquals(Orientation.WEST, rover.getOrientation());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(3, 7), rover.getPosition());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.NORTH, rover.getOrientation());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.EAST, rover.getOrientation());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 7), rover.getPosition());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.SOUTH, rover.getOrientation());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 6), rover.getPosition());
    }

    @Test
    @DisplayName("Test simply moving a Rover straight without turning.")
    void testMovingStraight() {
        Rover rover = new Rover(new Position(4, 6));

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 7), rover.getPosition());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 8), rover.getPosition());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 9), rover.getPosition());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 10), rover.getPosition());
    }
}