package ss11.s8;

import java.util.Stack;
import java.util.Scanner;

public class DecimalToBinary {
    // Hàm chuyển đổi số thập phân sang nhị phân
    public static String decimalToBinary(int decimalNumber) {
        // Khởi tạo Stack
        Stack<Integer> stack = new Stack<>();

        // Nếu số thập phân là 0, trả về "0"
        if (decimalNumber == 0) {
            return "0";
        }

        // Chuyển đổi thập phân sang nhị phân
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2; // Lấy phần dư
            stack.push(remainder);            // Đưa phần dư vào Stack
            decimalNumber /= 2;               // Lấy thương
        }

        // Đọc từ Stack để tạo số nhị phân
        StringBuilder binaryNumber = new StringBuilder();
        while (!stack.isEmpty()) {
            binaryNumber.append(stack.pop());
        }

        return binaryNumber.toString();
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số thập phân từ người dùng
        System.out.print("Nhập số thập phân cần chuyển đổi: ");
        int decimalNumber = scanner.nextInt();

        // Gọi hàm chuyển đổi
        String binaryResult = decimalToBinary(decimalNumber);

        // Hiển thị kết quả
        System.out.println("Số nhị phân của " + decimalNumber + " là: " + binaryResult);

        scanner.close();
    }
}
