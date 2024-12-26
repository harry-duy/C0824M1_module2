package finalTestDuy.view;

import finalTestDuy.model.IPhone;

import java.util.List;
import java.util.Scanner;


public class PhoneView {
    private final Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("\n--- Phone Management System ---");
        System.out.println("1. Add New Phone");
        System.out.println("2. Delete Phone");
        System.out.println("3. View Phone List");
        System.out.println("4. Search Phone");
        System.out.println("5. Exit");
    }

    public void displayPhones(List<IPhone> phones) {
        System.out.println("\n--- Phone List ---");
        if (phones.isEmpty()) {
            System.out.println("No phones in the list.");
        } else {
            phones.forEach(System.out::println);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                displayMessage("Invalid input. Please enter an integer.");
            }
        }
    }

    public double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                displayMessage("Invalid input. Please enter a number.");
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
