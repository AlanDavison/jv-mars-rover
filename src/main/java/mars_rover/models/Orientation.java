package mars_rover.models;

public enum Orientation {
    NORTH(new Position(0, 1)),
    EAST(new Position(1, 0)),
    SOUTH(new Position(0, -1)),
    WEST(new Position(-1, 0));

    Position forwardDirection;

    Orientation(Position direction) {
        this.forwardDirection = direction;
    }

    public Position getForwardDirection() {
        return this.forwardDirection;
    }
}
