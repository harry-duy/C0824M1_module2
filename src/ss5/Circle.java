package ss5;

public class Circle {
    private double radius = 1.0;
    public String color = "red";

    public Circle() {

    }
    public Circle(double radius) {
        this.radius = radius;
    }

    protected double getRadius() {
        return radius;
    }
    protected double getArea() {
        return Math.PI * radius * radius;
    }

}
