package ss1;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("You weight (in kilogram): ");
        weight = scanner.nextDouble();

        System.out.print("You height (in meter): ");
        height = scanner.nextDouble();

        bmi = weight / Math.pow(height, 2);

        if (bmi < 18.5) {
            System.out.printf("%-20.2f%s",bmi, "underweight");
        }else if (bmi >= 18.5 && bmi < 25.0) {
            System.out.printf("%-20.2f%s",bmi, "Normal");
        }else if (bmi >= 25.0 && bmi < 30.0) {
            System.out.printf("%-20.2f%s",bmi, "overweight");
        }else {
            System.out.printf("%-20.2f%s",bmi, "obese");
        }
    }
}
