package ss3;

import java.util.Scanner;
public class Student {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the size: ");
            size = sc.nextInt();
            if (size > 30) {
                System.out.println("The size of the array is too large.");
            }
        }while (size > 30);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter the mark for Student " + (i + 1) + ": ");
            array[i] = sc.nextInt();
            i++;
        }
        int count = 0;
        System.out.print("List of mark: ");
        for (int j=0; j < array.length; j++) {
            System.out.print(array[j] + " \t");
            if (array[j] >= 5 && array[j] <= 10) {
                count++;
            }
        }
            System.out.print(" \nThe number of students passing the exam is " + count );

    }
}
