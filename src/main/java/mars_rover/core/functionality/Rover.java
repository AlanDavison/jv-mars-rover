package mars_rover.core.functionality;

import mars_rover.core.models.MovementInstruction;
import mars_rover.core.models.Orientation;
import mars_rover.core.models.Position;
import mars_rover.core.models.RingBuffer;

public class Rover {
    private Position position;
    private RingBuffer<Orientation> orientation;
    private int currentOrientationIndex = 0;

    public Rover(Position position, int orientation) {
        this.position = position;
        this.orientation = new RingBuffer<>();
        this.orientation.add(Orientation.NORTH);
        this.orientation.add(Orientation.EAST);
        this.orientation.add(Orientation.SOUTH);
        this.orientation.add(Orientation.WEST);
        this.orientation.setCurrentElement(orientation);
    }

    public Position getPosition() {
        return this.position;
    }

    public Orientation getOrientation() {
        return this.orientation.getCurrentElement();
    }

    public void turnLeft() {
        this.orientation.shiftDown();
    }

    public void turnRight() {
        this.orientation.shiftUp();
    }

    public void receiveInstruction(MovementInstruction movementInstruction) {
        if (movementInstruction == MovementInstruction.TurnLeft || movementInstruction == MovementInstruction.TurnRight) {
            switch (movementInstruction) {
                case TurnLeft -> this.turnLeft();
                case TurnRight ->  this.turnRight();
            }

            return;
        }

        this.position = this.position.adjustBy(this.orientation.getCurrentElement().getForwardDirection());
    }
}
