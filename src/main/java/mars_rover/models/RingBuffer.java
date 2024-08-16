package mars_rover.models;

import java.util.ArrayList;

public class RingBuffer<E> {
    ArrayList<E> elements;
    int currentIndex = 0;

    public RingBuffer() {
        this.elements = new ArrayList<>();
    }

    public void add(E element) {
        this.elements.add(element);
    }

    public void shiftDown() {
        if (this.currentIndex == 0)
            this.currentIndex = this.elements.size() - 1;
        else
            this.currentIndex--;
    }

    public void shiftUp() {
        if (this.currentIndex == this.elements.size() - 1)
            this.currentIndex = 0;
        else
            this.currentIndex++;
    }

    public E getCurrentElement() {
        if (this.elements.isEmpty())
            return null;

        return this.elements.get(currentIndex);
    }
}
