package mars_rover.functionality;

import mars_rover.models.Instruction;
import mars_rover.models.Orientation;
import mars_rover.models.Position;

public class Rover {
    private Position position;
    private Orientation orientation;

    public Rover(Position position) {
        this.position = position;
        this.orientation = Orientation.NORTH;
    }

    public Position getPosition() {
        return this.position;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void receiveInstruction(Instruction instruction) {

    }
}
