package ss7;

import ss6.s1.Circle;
import ss7.Comparable.CircleComparator;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5,"indigo",false);

        System.out.println("Pre-sorted");
        for (Circle c : circles) {
            System.out.println(c);
        }

        Comparator c = new CircleComparator();
        Arrays.sort(circles, c);
        System.out.println("After-sorted");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}
