package ss3;

import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fahrenheit;
        double celsius ;
        int choice;

        do {
            System.out.print("Menu. ");
            System.out.println("1. Fahrenheit");
            System.out.println("2. Celsius");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Fahrenheit: ");
                    fahrenheit = sc.nextDouble();
                    System.out.println("Fahrengeit to Celsius: "+ fahrenheitToCelsius(fahrenheit));
                    break;
                }
                case 2: {
                    System.out.println("Celsius: ");
                    celsius = sc.nextDouble();
                    System.out.println("Celsius to Fahrenheit: "+ celsiusToFahrenheit(celsius));
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
            }while (true);

    }
    public static double celsiusToFahrenheit(double celsius) {
        return (9.0/5) * celsius + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0/9)*(fahrenheit - 32);
    }
}