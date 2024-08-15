package mars_rover.functionality;

import mars_rover.models.Instruction;
import mars_rover.models.Position;

import java.util.ArrayList;

public class MissionControl {
    private ArrayList<Rover> rovers = new ArrayList<>();

    private boolean instructRover(Rover rover, Instruction instruction) {

        return false;
    }

    private boolean isPositionValid(Rover rover, Position position) {

        return false;
    }

    public void receiveInstruction(Rover rover, Instruction instruction) {
        if (instruction == instruction.MoveForward) {
            if (this.isPositionValid(rover, rover.getPosition().adjustBy(rover.getOrientation().getForwardDirection()))) {
                this.instructRover(rover, instruction);
            }
        } else {
            this.instructRover(rover, instruction);
        }
    }
}
