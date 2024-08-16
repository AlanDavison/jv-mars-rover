package mars_rover.console.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidCommandsTest {
    private ValidCommands commands = new ValidCommands();

    @Test
    @DisplayName("Test command validity with commands that exist.")
    void testValidCommandsMapWithRealCommands() {
        assertTrue(commands.isValidCommand("spawn"));
        assertTrue(commands.isValidCommand("move"));
        assertTrue(commands.isValidCommand("quit"));
        assertFalse(commands.isValidCommand("quitt"));
    }

    @Test
    @DisplayName("Test command validity with commands that don't exist.")
    void testValidCommandsMapWithFakeCommands() {
        assertFalse(commands.isValidCommand("quitt"));
        assertFalse(commands.isValidCommand("g4567n[]"));
        assertFalse(commands.isValidCommand("46247.;"));
    }

}