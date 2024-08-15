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
    @DisplayName("Test giving a Rover instructions and check if it obeys correctly.")
    void receiveInstruction() {
        Rover rover = new Rover(new Position(4, 6));

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 5), rover.getPosition());

        rover.receiveInstruction(Instruction.TurnLeft);
        assertEquals(Orientation.WEST, rover.getOrientation());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(3, 5), rover.getPosition());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.NORTH, rover.getOrientation());

        rover.receiveInstruction(Instruction.TurnRight);
        assertEquals(Orientation.EAST, rover.getOrientation());

        rover.receiveInstruction(Instruction.MoveForward);
        assertEquals(new Position(4, 5), rover.getPosition());
    }
}