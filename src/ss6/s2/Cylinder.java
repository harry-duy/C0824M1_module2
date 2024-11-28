package ss6.s2;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Hình trụ có bán kính " + getRadius() + ", màu " + getColor() + ", chiều cao " + height + ", diện tích đáy là " + getArea() + ", thể tích là " + getVolume();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(5, "đỏ", 10);
        System.out.println(cylinder.toString());
        cylinder.setHeight(20);
        System.out.println(cylinder.toString());
    }
}
