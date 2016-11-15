package model;

/**
 * Created by HP on 10/30/2016.
 */
public class PositionImpl implements Position {

    private final double h;
    private final double v;

    public PositionImpl(double h, double v) {
        this.h = h;
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
