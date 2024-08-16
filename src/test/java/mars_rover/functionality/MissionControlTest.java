package mars_rover.functionality;

import mars_rover.models.Plateau;
import mars_rover.models.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    @Test
    @DisplayName("Test Position validity checking with Rovers placed and desired co-ordinate is within plateau bounds.")
    void testPositionValidityWithRoversAndWithinPlateauBounds() {
        MissionControl control = new MissionControl(new Plateau(10, 10));
        Rover roverOne = new Rover(new Position(3, 5));
        Rover roverTwo = new Rover(new Position(0, 0));
        Rover roverThree = new Rover(new Position(0, 10));
        Rover roverFour = new Rover(new Position(10, 0));
        control.addRover(roverOne);
        control.addRover(roverTwo);
        control.addRover(roverThree);
        control.addRover(roverFour);

        assertTrue(control.isPositionFree(new Position(0, 1)));
        assertTrue(control.isPositionFree(new Position(1, 0)));
        assertTrue(control.isPositionFree(new Position(10, 10)));
        assertFalse(control.isPositionFree(new Position(10, 0)));
        assertFalse(control.isPositionFree(new Position(0, 10)));
        assertFalse(control.isPositionFree(new Position(3, 5)));
        assertFalse(control.isPositionFree(new Position(0, 0)));
    }

    @Test
    @DisplayName("Test Position validity checking with Rovers placed and desired co-ordinate is outside of plateau bounds.")
    void testPositionValidityWithRoversAndQueriedTileOutsidePlateauBounds() {
        MissionControl control = new MissionControl(new Plateau(10, 10));
        Rover roverOne = new Rover(new Position(3, 5));
        Rover roverTwo = new Rover(new Position(0, 0));
        Rover roverThree = new Rover(new Position(0, 10));
        Rover roverFour = new Rover(new Position(10, 0));
        control.addRover(roverOne);
        control.addRover(roverTwo);
        control.addRover(roverThree);
        control.addRover(roverFour);

        assertFalse(control.isPositionFree(new Position(11, 0)));
        assertFalse(control.isPositionFree(new Position(0, 11)));
        assertFalse(control.isPositionFree(new Position(11, 11)));
        assertFalse(control.isPositionFree(new Position(Integer.MAX_VALUE, Integer.MIN_VALUE)));
    }

    @Test
    @DisplayName("Test adding Rovers outisde of Plateau bounds.")
    void testAddingRoversOutsideOfPlateauBounds() {
        MissionControl control = new MissionControl(new Plateau(10, 10));
        Rover roverOne = new Rover(new Position(Integer.MIN_VALUE, Integer.MAX_VALUE));
        Rover roverTwo = new Rover(new Position(11, 11));
        Rover roverThree = new Rover(new Position(0, 11));
        Rover roverFour = new Rover(new Position(11, 0));

        assertFalse(control.addRover(roverOne));
        assertFalse(control.addRover(roverTwo));
        assertFalse(control.addRover(roverThree));
        assertFalse(control.addRover(roverFour));
    }

}