package mars_rover.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Test the associated movement direction with each enum value.")
    public void testMovementDirections() {
        Position expectedNorthMovement = new Position(0, 1);
        Position expectedEastMovement = new Position(1, 0);
        Position expectedSouthMovement = new Position(0, -1);
        Position expectedWestMovement = new Position(-1, 0);

        assertNotEquals(expectedWestMovement, expectedNorthMovement);
        assertNotEquals(expectedEastMovement, expectedNorthMovement);
        assertAll(
                () -> assertEquals(expectedNorthMovement, expectedNorthMovement),
                () -> assertEquals(expectedEastMovement, expectedEastMovement),
                () -> assertEquals(expectedSouthMovement, expectedSouthMovement),
                () -> assertEquals(expectedWestMovement, expectedWestMovement)
        );
    }

}