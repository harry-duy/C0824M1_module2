package ss2;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = sc.nextDouble();

        System.out.println("Enter monthly investment amount: ");
        month = sc.nextInt();

        System.out.println("Enter interest rate: ");
        interestRate = sc.nextDouble();

        double total = 0;
        for (int i = 0; i < month; i++) {
            total += money * (interestRate /100)/12 *month;
        }
        System.out.println("Total interest rate: " + total);

    }
}
