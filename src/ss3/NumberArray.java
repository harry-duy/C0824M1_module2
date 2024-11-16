package ss3;

import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        int[] array;
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size should be less than 20");
            }
        }while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter " + (i+1) + ": ");
            array[i] = sc.nextInt();
            i++;
        }
        System.out.print("Property list: ");
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t ");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j+1;
            }
        }
        System.out.println("Max: " + max + " Index: " + index);
    }
}
