package ss7.shape;

public class Square2 extends Rectangle implements Colorable{
    public Square2(double side) {
        super(side, side);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}
