package ss2;

import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice = -1;
        Scanner sc = new Scanner(System.in);

        while(choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            int rows = 5;
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    for (int i=0 ; i < 3; i++){
                        for (int j=0 ; j < 7 ; j++){
                            System.out.print(" *");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
                    System.out.println("==============");
                    System.out.println("TopLeftRightTriangle");
                    for (int i = 1; i <= rows; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Move to the next line after each row
                    }
                    System.out.println("==============");
                    System.out.println("TopRightRightTriangle");
                    for (int i = 1; i <= rows; i++) {
                        // Print spaces for alignment
                        for (int j = 1; j <= rows - i; j++) {
                            System.out.print(" ");
                        }
                        // Print asterisks
                        for (int k = 1; k <= i; k++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Move to the next line after each row
                    }
                    System.out.println("==============");
                    System.out.println("BottomLeftRightTriangle");
                    for (int i = rows; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Move to the next line after each row
                    }
                    System.out.println("==============");
                    System.out.println("BottomRightRightTriangle");
                    for (int i = rows; i >= 1; i--) {
                        // Print spaces for alignment
                        for (int j = 1; j <= rows - i; j++) {
                            System.out.print(" ");
                        }
                        // Print asterisks
                        for (int k = 1; k <= i; k++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Move to the next line after each row
                    }
                    break;
                case 3:
                    System.out.println("Print isosceles triangle");
                    for (int i = 1; i <= rows; i++) {
                        // Print spaces for alignment
                        for (int j = 1; j <= rows - i; j++) {
                            System.out.print(" ");
                        }
                        // Print asterisks
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("*");
                        }
                        System.out.println(); // Move to the next line after each row
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }


    }
}
