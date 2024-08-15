package mars_rover.models;

public class Vector2 {
    private int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Vector2))
            return false;
        if (obj == this)
            return true;

        return ((Vector2) obj).getX() == this.getX() &&
                ((Vector2) obj).getY() == this.getY();
    }
}
