package mars_rover.core.models;

public class Plateau {
    private final int width, height;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
