package model;

/**
 * Created by Sidi on 10/30/2016.
 */
public class MovingPositionImpl implements MovingPosition {
    private double h;
    private double v;

    public MovingPositionImpl(Position position) {
        h = position.getH();
        v = position.getV();
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setV(double v) {
        this.v = v;
    }

    @Override
    public double getH() {
        return h;
    }

    @Override
    public double getV() {
        return v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Position))
            return false;

        Position position = (Position) o;
        return h == position.getH() && v == position.getV();
    }

    @Override
    public int hashCode() {
        int result = (int) h;
        result = 31 * result + (int) v;
        return result;
    }
}
