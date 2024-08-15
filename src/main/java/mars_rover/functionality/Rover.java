package mars_rover.functionality;

import mars_rover.models.Instruction;
import mars_rover.models.Orientation;
import mars_rover.models.Position;
import mars_rover.models.RingBuffer;

public class Rover {
    private Position position;
    private RingBuffer<Orientation> orientation;

    public Rover(Position position) {
        this.position = position;
        this.orientation = new RingBuffer<>();
        this.orientation.add(Orientation.NORTH);
        this.orientation.add(Orientation.EAST);
        this.orientation.add(Orientation.SOUTH);
        this.orientation.add(Orientation.WEST);
    }

    public Position getPosition() {
        return this.position;
    }

    public Orientation getOrientation() {
        return this.orientation.getCurrentElement();
    }

    public void receiveInstruction(Instruction instruction) {

    }
}
