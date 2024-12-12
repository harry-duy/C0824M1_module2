package ss8.s1;
import java.lang.String;

public class Calculator {
    public static final String ADDITION = "+";
    public static final String SUBTRACTION = "-";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    public static double calculate(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                return firstOperand / secondOperand;
            default:
                throw new UnsupportedOperationException("Unsupported operation");
        }
    }
}
