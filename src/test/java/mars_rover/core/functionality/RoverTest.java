package mars_rover.core.functionality;

import mars_rover.core.helpers.InstructionParser;
import mars_rover.core.models.MovementInstruction;
import mars_rover.core.models.Orientation;
import mars_rover.core.models.Plateau;
import mars_rover.core.models.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Test Rover rotation instructions.")
    void testReceiveRotationInstructions() {
        Rover rover = new Rover(new Position(4, 6), 0);

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.EAST, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.SOUTH, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.WEST, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.NORTH, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnLeft);
        assertEquals(Orientation.WEST, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnLeft);
        assertEquals(Orientation.SOUTH, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnLeft);
        assertEquals(Orientation.EAST, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnLeft);
        assertEquals(Orientation.NORTH, rover.getOrientation());

        rover = new Rover(new Position(4, 6), 0);
        MissionControl control = new MissionControl(new Plateau(10, 10));

        control.addRover(rover);
        String moveCommand = "RRRR";

        assertEquals(Orientation.NORTH, rover.getOrientation());

        Optional<LinkedList<MovementInstruction>> instructions = InstructionParser.parseInstructions(moveCommand);

        for (var instruction: instructions.get()) {
            if (!control.getCurrentRover().isPresent())
                continue;

            control.receiveInstruction(control.getCurrentRover().get(), instruction);
        }

        assertEquals(Orientation.NORTH, rover.getOrientation());

        moveCommand = "LLLL";

        assertEquals(Orientation.NORTH, rover.getOrientation());

        instructions = InstructionParser.parseInstructions(moveCommand);

        for (var instruction: instructions.get()) {
            if (!control.getCurrentRover().isPresent())
                continue;

            control.receiveInstruction(control.getCurrentRover().get(), instruction);
        }

        assertEquals(Orientation.NORTH, rover.getOrientation());
    }

    @Test
    @DisplayName("Test giving a Rover all types of instructions and check if it obeys correctly.")
    void testReceiveMixedInstruction() {
        Rover rover = new Rover(new Position(4, 6), 0);

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 7), rover.getPosition());

        rover.receiveInstruction(MovementInstruction.TurnLeft);
        assertEquals(Orientation.WEST, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(3, 7), rover.getPosition());

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.NORTH, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.EAST, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 7), rover.getPosition());

        rover.receiveInstruction(MovementInstruction.TurnRight);
        assertEquals(Orientation.SOUTH, rover.getOrientation());

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 6), rover.getPosition());
    }

    @Test
    @DisplayName("Test simply moving a Rover straight without turning.")
    void testMovingStraight() {
        Rover rover = new Rover(new Position(4, 6), 0);

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 7), rover.getPosition());

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 8), rover.getPosition());

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 9), rover.getPosition());

        rover.receiveInstruction(MovementInstruction.MoveForward);
        assertEquals(new Position(4, 10), rover.getPosition());
    }

    @Test
    @DisplayName("Test receiving instructions via MissionControl.")
    void testReceiveInstructionsViaMissionControl() {
        MissionControl control = new MissionControl(new Plateau(10, 10));
        Rover rover = new Rover(new Position(5, 5), 0);
        control.addRover(rover);
        String moveCommand = "MLMMRMRMRMLMRMRR";

        assertEquals(new Position(5, 5), rover.getPosition());
        assertEquals(Orientation.NORTH, rover.getOrientation());

        Optional<LinkedList<MovementInstruction>> instructions = InstructionParser.parseInstructions(moveCommand);

        for (var instruction: instructions.get()) {
            if (!control.getCurrentRover().isPresent())
                continue;

            control.receiveInstruction(control.getCurrentRover().get(), instruction);
        }

        assertEquals(new Position(5, 5), rover.getPosition());
        assertEquals(Orientation.NORTH, rover.getOrientation());
    }
}