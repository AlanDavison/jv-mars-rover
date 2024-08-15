package mars_rover.models;

public class Position {
    private int x, y;

    public Position(int x, int y) {
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

    public Position adjustBy(Position position) {
        this.x += position.getX();
        this.y += position.getY();

        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Position))
            return false;
        if (obj == this)
            return true;

        return ((Position) obj).getX() == this.getX() &&
                ((Position) obj).getY() == this.getY();
    }
}
