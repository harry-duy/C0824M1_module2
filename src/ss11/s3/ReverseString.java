package ss11.s3;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString {

    public static String reverseString(String str) {
        if (str == null || str.isEmpty()) { // Xử lý trường hợp null hoặc chuỗi rỗng
            return str;
        }

        Deque<String> stack = new ArrayDeque<>();
        // Sử dụng regex để xử lý nhiều khoảng trắng giữa các từ
        String[] words = str.split("\\s+"); // Split theo 1 hoặc nhiều khoảng trắng

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop()).append(" ");
        }

        return reversedString.toString().trim(); // Loại bỏ khoảng trắng thừa ở cuối
    }

    public static void main(String[] args) {
        String str1 = "Đây là một ví dụ";
        System.out.println("Chuỗi 1 sau khi đảo ngược: \"" + reverseString(str1) + "\""); // "ví dụ một là Đây"

        String str2 = "  Đây   là    ví dụ  "; // Nhiều khoảng trắng
        System.out.println("Chuỗi 2 sau khi đảo ngược: \"" + reverseString(str2) + "\""); // "ví dụ là Đây"

        String str3 = ""; // Chuỗi rỗng
        System.out.println("Chuỗi 3 sau khi đảo ngược: \"" + reverseString(str3) + "\""); // ""

        String str4 = null; // Chuỗi null
        System.out.println("Chuỗi 4 sau khi đảo ngược: \"" + reverseString(str4) + "\""); // null

    }
}
