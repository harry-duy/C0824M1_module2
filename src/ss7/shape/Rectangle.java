package ss7.shape;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    @Override
    public  double getArea() {
        return width * height;
    }
    @Override
    public void resize(double percent) {
        width *= (1+ percent/100);
        height *= (1+ percent/100);
    }
}
