package ss11.s10;

import java.util.Stack;

public class BracketChecker {
    public static boolean checkBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (!match(left, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(char left, char right) {
        return (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}');
    }

    public static void main(String[] args) {
        String expression1 = "s * (s – a) * (s – b) * (s – c)";
        System.out.println("Biểu thức '" + expression1 + "' sử dụng dấu ngoặc đúng: " + checkBrackets(expression1));

        String expression2 = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        System.out.println("Biểu thức '" + expression2 + "' sử dụng dấu ngoặc đúng: " + checkBrackets(expression2));

        String expression3 = "s * (s – a) * (s – b * (s – c)";
        System.out.println("Biểu thức '" + expression3 + "' sử dụng dấu ngoặc đúng: " + checkBrackets(expression3));

        String expression4 = "s * (s – a) * s – b) * (s – c)";
        System.out.println("Biểu thức '" + expression4 + "' sử dụng dấu ngoặc đúng: " + checkBrackets(expression4));

        String expression5 = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        System.out.println("Biểu thức '" + expression5 + "' sử dụng dấu ngoặc đúng: " + checkBrackets(expression5));
    }
}
