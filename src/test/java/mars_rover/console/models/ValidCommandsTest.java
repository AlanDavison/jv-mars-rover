package mars_rover.console.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidCommandsTest {

    @Test
    @DisplayName("Test command validity with commands that exist.")
    void testValidCommandsMapWithRealCommands() {
        assertTrue(ValidCommands.isValidCommand("spawn"));
        assertTrue(ValidCommands.isValidCommand("move"));
        assertTrue(ValidCommands.isValidCommand("quit"));
        assertFalse(ValidCommands.isValidCommand("quitt"));
    }

    @Test
    @DisplayName("Test command validity with commands that don't exist.")
    void testValidCommandsMapWithFakeCommands() {
        assertFalse(ValidCommands.isValidCommand("quitt"));
        assertFalse(ValidCommands.isValidCommand("g4567n[]"));
        assertFalse(ValidCommands.isValidCommand("46247.;"));
    }

}