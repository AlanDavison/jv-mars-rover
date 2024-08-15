package mars_rover.models;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {
    private static Orientation orientationNorth;
    private static Orientation orientationEast;
    private static Orientation orientationSouth;
    private static Orientation orientationWest;

    @BeforeAll
    public static void setupOrientation() {
        orientationNorth = Orientation.NORTH;
        orientationEast = Orientation.EAST;
        orientationSouth = Orientation.SOUTH;
        orientationWest = Orientation.WEST;
    }

}