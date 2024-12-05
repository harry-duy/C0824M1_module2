package ss7.shape;

public class Square  extends Shape implements Resizeable {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    @Override
    public void resize(double percent) {
        side *= ( 1 + percent / 100 );
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
