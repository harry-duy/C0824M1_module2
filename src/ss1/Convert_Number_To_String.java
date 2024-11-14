package ss1;
import java.util.Scanner;
public class Convert_Number_To_String {
    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    private static final String[] teens = {
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };
    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (0-999): ");
        int number = scanner.nextInt();
        System.out.println(numberToWords(number));
    }
    private static String numberToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        String words = "";

        if (number / 100 > 0) {
            words += units[number / 100] + " hundred ";
            number %= 100;
        }

        if (number >= 10 && number < 20) {
            words += teens[number - 10];
        } else {
            if (number / 10 > 0) {
                words += tens[number / 10] + " ";
            }
            if (number % 10 > 0) {
                words += units[number % 10];
            }
        }

        return words.trim();
    }
}
