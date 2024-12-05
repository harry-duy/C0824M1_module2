package ss7;

import ss7.shape.*;

public class TestColorableSquare {
    public static void main(String[] args) {
        // Tạo mảng các đối tượng hình học
        Shape[] shapes = new Shape[3];
        shapes[0] = new Square2(4);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(6);

        // Hiển thị diện tích của mỗi phần tử và gọi phương thức howToColor() nếu có
        for (Shape shape : shapes) {
            System.out.println("Diện tích của hình: " + shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
