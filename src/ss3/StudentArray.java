package ss3;

import java.util.Scanner;

public class StudentArray {
    public static void main(String[] args) {
        String[] names = {"Chritian", "Michael", "James", "Bob", "Jennifer"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        boolean isExist = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                System.out.println("Position of the student in the list "+ name + "is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }
}
