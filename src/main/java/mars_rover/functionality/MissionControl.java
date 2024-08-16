package mars_rover.functionality;

import mars_rover.models.Instruction;
import mars_rover.models.Plateau;
import mars_rover.models.Position;

import java.util.ArrayList;

public class MissionControl {
    private ArrayList<Rover> rovers = new ArrayList<>();
    private Plateau plateau;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
    }

    public boolean addRover(Rover rover) {
        if (this.isPositionFree(rover.getPosition()))
            return this.rovers.add(rover);

        return false;
    }

    private boolean instructRover(Rover rover, Instruction instruction) {

        return false;
    }

    private boolean isPositionValid(Rover rover, Position position) {

        return false;
    }

    public boolean isPositionFree(Position desiredPosition) {
        if (desiredPosition.getX() > this.plateau.getWidth() || desiredPosition.getY() > this.plateau.getHeight())
            return false;

        ArrayList<Position> roverPositions = new ArrayList<>();

        for (Rover rover: this.rovers) {
            roverPositions.add(rover.getPosition());
        }

        for (int i = 0; i < this.plateau.getWidth(); i++) {
            for (int j = 0; j < this.plateau.getHeight(); j++) {
                for (Position position: roverPositions) {
                    if (position.getX() == desiredPosition.getX() && position.getY() == desiredPosition.getY())
                        return false;
                }
            }
        }

        return true;
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
