package ss2;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a ;
        int b ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = sc.nextInt();

        System.out.println("Enter b: ");
        b = sc.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0) {
            System.out.println("No Greatest Common Factor");
        }
        while (a != b ){
            if (a > b){
                a = a - b;
            }else
                b = b - a;
        }

        System.out.println("Greatest Common Factor = " + a);
    }
}
