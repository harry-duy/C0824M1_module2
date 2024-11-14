package ss1;

import java.util.Scanner;

public class LinearEquationResolve {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolve");
        System.out.println("Give a equation as 'a * x + b = c', please enter constants:");
        Scanner sc = new Scanner(System.in);

        System.out.println("a: ");
        double a = sc.nextDouble();

        System.out.println("b: ");
        double b = sc.nextDouble();

        System.out.println("c: ");
        double c = sc.nextDouble();

        if (a != 0){
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f\n", answer);
        } else {
            if (b == c){
                System.out.print("The solution is all x!");
            }else {
                System.out.print("No solution found!");
            }

        }
    }
}
