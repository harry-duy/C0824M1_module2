package ss7;

import ss7.shape.*;

import java.util.Random;

public class TestInterface {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(4, 6);
        shapes[2] = new Square(3);

        Random rand = new Random();

        System.out.println("Thông tin trước khi tăng kích thước:");
        for (Shape shape : shapes) {
            System.out.println(shapeInfo(shape));
        }

        System.out.println("\nTăng kích thước các hình:");
        for (Shape shape : shapes) {
            if (shape instanceof Resizeable) {
                double percent = 1 + rand.nextInt(100); // Tỷ lệ từ 1-100%
                double areaBefore = shape.getArea();
                ((Resizeable) shape).resize(percent);
                double areaAfter = shape.getArea();
                System.out.println(shape.getClass().getSimpleName() + " đã được tăng kích thước lên " + percent + "%");
                System.out.println("Diện tích trước: " + String.format("%.2f", areaBefore));
                System.out.println("Diện tích sau: " + String.format("%.2f", areaAfter));
                System.out.println();
            }
        }
    }

    public static String shapeInfo(Shape shape) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            return "Circle: radius = " + c.getRadius() + ", area = " + String.format("%.2f", c.getArea());
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return "Rectangle: width = " + r.getWidth() + ", height = " + r.getHeight() + ", area = " + String.format("%.2f", r.getArea());
        } else if (shape instanceof Square) {
            Square s = (Square) shape;
            return "Square: side = " + s.getSide() + ", area = " + String.format("%.2f", s.getArea());
        } else {
            return "Unknown Shape";
        }
    }
}
