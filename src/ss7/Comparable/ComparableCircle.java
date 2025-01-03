package ss7.Comparable;

import ss6.s1.Circle;

public class ComparableCircle extends Circle
            implements Comparable<ComparableCircle> {
    public ComparableCircle() {

    }
    public ComparableCircle(double radius) {
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) {
            return 1;
        }else if (getRadius() < o.getRadius()) {
            return -1;
        }else return 0;
    }

}
