package mars_rover.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2Test {
    private Vector2 vectorOne = new Vector2(5, 7);
    private Vector2 vectorTwo = new Vector2(-100, 8);
    private Vector2 vectorThree = new Vector2(42, 42);
    private Vector2 vectorFour = new Vector2(5, 7);
    private Vector2 vectorFive = new Vector2(-100, 8);
    private Vector2 vectorSix = new Vector2(42, 42);

    @Test
    @DisplayName("Test Vector2 custom .equals override")
    public void testVector2EqualsOverride() {
        assertEquals(vectorOne, vectorFour);
        assertEquals(vectorTwo, vectorFive);
        assertEquals(vectorThree, vectorSix);
        assertNotEquals(vectorOne, vectorTwo);
        assertNotEquals(vectorSix, vectorFive);
    }
}