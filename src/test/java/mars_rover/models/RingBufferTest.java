package mars_rover.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferTest {

    @Test
    @DisplayName("Test RingBuffer functionality with elements added.")
    void testRingBufferFunctionalityWithElementsAdded() {
        RingBuffer<Orientation> buffer = new RingBuffer<>();
        buffer.add(Orientation.NORTH);
        buffer.add(Orientation.EAST);
        buffer.add(Orientation.SOUTH);
        buffer.add(Orientation.WEST);

        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftDown();
        assertEquals(Orientation.WEST, buffer.getCurrentElement());

        buffer.shiftDown();
        assertEquals(Orientation.SOUTH, buffer.getCurrentElement());

        buffer.shiftUp();
        assertEquals(Orientation.WEST, buffer.getCurrentElement());

        buffer.shiftUp();
        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftUp();
        assertEquals(Orientation.EAST, buffer.getCurrentElement());
    }

    @Test
    @DisplayName("Test RingBuffer functionality with only one element.")
    void testRingBufferFunctionalityWithOneElementOnly() {
        RingBuffer<Orientation> buffer = new RingBuffer<>();
        buffer.add(Orientation.NORTH);

        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftDown();
        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftDown();
        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftUp();
        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftUp();
        assertEquals(Orientation.NORTH, buffer.getCurrentElement());

        buffer.shiftUp();
        assertEquals(Orientation.NORTH, buffer.getCurrentElement());
    }

    @Test
    @DisplayName("Test RingBuffer functionality with zero elements.")
    void testRingBufferFunctionalityWhenEmpty() {
        RingBuffer<Orientation> buffer = new RingBuffer<>();

        assertNull(buffer.getCurrentElement());

        buffer.shiftDown();
        assertNull(buffer.getCurrentElement());

        buffer.shiftDown();
        assertNull(buffer.getCurrentElement());

        buffer.shiftUp();
        assertNull(buffer.getCurrentElement());

        buffer.shiftUp();
        assertNull(buffer.getCurrentElement());

        buffer.shiftUp();
        assertNull(buffer.getCurrentElement());
    }
}