package ss1;

import java.util.Scanner;

public class change_money {
    public static void main(String[] args) {
        double vnd = 23000f;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a USD: ");
        usd = sc.nextDouble();
        double change = usd * vnd;
        System.out.println("Value vnd = " + change);
    }
}
