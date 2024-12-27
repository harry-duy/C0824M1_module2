package ss15.s4;

import java.util.Scanner;

public class TriangleChecker {

    // Phương thức kiểm tra tam giác
    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Các cạnh phải là số dương.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh phải lớn hơn cạnh còn lại.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Nhập 3 cạnh từ người dùng
            System.out.print("Nhập cạnh thứ nhất: ");
            double a = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ hai: ");
            double b = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ ba: ");
            double c = scanner.nextDouble();

            // Kiểm tra tam giác
            checkTriangle(a, b, c);

            System.out.println("Ba cạnh này tạo thành một tam giác hợp lệ.");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi. Vui lòng nhập đúng định dạng.");
        } finally {
            scanner.close();
        }
    }
}
