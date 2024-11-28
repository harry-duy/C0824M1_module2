package ss6.s5;

import java.util.Scanner;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Nhập độ dài các cạnh
        System.out.print("Enter side1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter side2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter side3: ");
        double side3 = input.nextDouble();

        // Nhập màu sắc
        System.out.print("Enter color: ");
        String color = input.next();

        // Tạo tam giác
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);

        // In kết quả
        System.out.println("\nTriangle information:");
        System.out.println("Color: " + triangle.getColor());
        System.out.printf("Area: %.2f\n", triangle.getArea());
        System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());
        System.out.println(triangle.toString());

        input.close();
    }
}
