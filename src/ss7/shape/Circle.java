package ss7.shape;

public class Circle extends Shape implements Resizeable {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public void resize(double percent){
        radius *= (1 + percent/100);
    }
}
