package mars_rover.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position positionOne = new Position(5, 7);
    private Position positionTwo = new Position(-100, 8);
    private Position positionThree = new Position(42, 42);
    private Position positionFour = new Position(5, 7);
    private Position positionFive = new Position(-100, 8);
    private Position positionSix = new Position(42, 42);

    @Test
    @DisplayName("Test Vector2 custom .equals override")
    public void testVector2EqualsOverride() {
        assertEquals(positionOne, positionFour);
        assertEquals(positionTwo, positionFive);
        assertEquals(positionThree, positionSix);
        assertNotEquals(positionOne, positionTwo);
        assertNotEquals(positionSix, positionFive);
    }
}