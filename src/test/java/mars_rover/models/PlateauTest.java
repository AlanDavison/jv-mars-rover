package mars_rover.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("Test whether instantiating a plateau with a given size correctly returns that size.")
    public void testPlateauSizing() {
        Plateau plateau = new Plateau(10, 7);

        assertEquals(10, plateau.getWidth());
        assertEquals(7, plateau.getHeight());
    }

}