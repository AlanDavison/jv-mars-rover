package mars_rover.models;

public enum Orientation {
    NORTH(new Vector2(0, 1)),
    EAST(new Vector2(1, 0)),
    SOUTH(new Vector2(0, -1)),
    WEST(new Vector2(-1, 0));

    Vector2 forwardDirection;

    Orientation(Vector2 direction) {
        this.forwardDirection = direction;
    }
}
