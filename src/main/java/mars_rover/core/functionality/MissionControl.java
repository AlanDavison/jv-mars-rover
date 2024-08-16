package mars_rover.core.functionality;

import mars_rover.core.models.MovementInstruction;
import mars_rover.core.models.Orientation;
import mars_rover.core.models.Plateau;
import mars_rover.core.models.Position;

import java.util.ArrayList;
import java.util.Optional;

public class MissionControl {
    private ArrayList<Rover> rovers = new ArrayList<>();
    private Plateau plateau;
    private int currentRoverIndex = 0;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
    }

    public boolean addRover(Rover rover) {
        if (this.isPositionFree(rover.getPosition())) {
            if (this.rovers.add(rover)) {
                this.currentRoverIndex = this.rovers.indexOf(rover);
                return true;
            }
        }

        return false;
    }

    public Optional<Rover> getCurrentRover() {
        Rover rover = this.rovers.get(this.currentRoverIndex);
        if (rover == null)
            return Optional.empty();

        return Optional.of(rover);
    }

    public void printRoverDetail(Rover rover) {
        System.out.println("Rover at X:" + rover.getPosition().getX() + ", Y:" + rover.getPosition().getY() + " facing " + rover.getOrientation());
    }

    public void selectRover(Position position) {

    }

    private boolean instructRover(Rover rover, MovementInstruction movementInstruction) {
        if (rover == null)
            return false;

        switch (movementInstruction) {
            case TurnLeft -> {
                rover.turnLeft();
                return true;
            }
            case TurnRight -> {
                rover.turnRight();
                return true;
            }
        }

        return false;
    }

    private boolean isPositionValid(Rover rover, Position position) {
        if (position.getX() < 0 || position.getY() < 0)
            return false;
        if (!isPositionFree(position))
            return false;

        return true;
    }

    public boolean isPositionFree(Position desiredPosition) {
        if (desiredPosition.getX() > this.plateau.getWidth() || desiredPosition.getY() > this.plateau.getHeight())
            return false;
        if (desiredPosition.getX() < 0 || desiredPosition.getY() < 0)
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

    public void receiveInstruction(Rover rover, MovementInstruction movementInstruction) {
        if (movementInstruction == movementInstruction.MoveForward) {
            Orientation orientation = rover.getOrientation();
            if (this.isPositionValid(rover, rover.getPosition().adjustBy(orientation.getForwardDirection()))) {
                this.instructRover(rover, movementInstruction);
            }
            else
                return;
        } else {
            this.instructRover(rover, movementInstruction);
        }
    }
}
