package ss11.s9;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeChecker {
    public static boolean checkPalindrome(String input) {
        // Tạo một Stack và một Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Đọc chuỗi vào Stack và Queue
        for (char c : input.toLowerCase().toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        // So sánh từng phần tử của Stack và Queue
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "Able was I ere I saw Elba";
        System.out.println("Chuỗi '" + input + "' là palindrome: " + checkPalindrome(input));
    }
}
