package mars_rover.console.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    void testIsValidCommandWithGoodInput() {
        assertTrue(CommandParser.isValidCommand("spawn 5 1 W"));
        assertTrue(CommandParser.isValidCommand("spawn 10 1 S"));
        assertTrue(CommandParser.isValidCommand("move LLMRMMRMMRMRMR"));
        assertFalse(CommandParser.isValidCommand("spawn 5 1 0W"));
        assertFalse(CommandParser.isValidCommand("move LMMMMMT"));
        assertFalse(CommandParser.isValidCommand("spawn -1 0 E"));
    }

    @Test
    void testIsValidCommandWithBadInput() {
    }

    @Test
    void testIsValidSpawnCommandWithGoodInput() {
    }

    @Test
    void testIsValidSpawnCommandWithBadInput() {
    }

    @Test
    void testGetCommandTypeWithGoodInput() {
    }

    @Test
    void testGetCommandTypeWithBadInput() {
    }

    @Test
    void testGetPositionFromSpawnCommandWithGoodInput() {
    }

    @Test
    void testGetPositionFromSpawnCommandWithBadInput() {
    }
}