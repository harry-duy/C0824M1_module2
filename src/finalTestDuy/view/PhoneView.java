package finalTestDuy.view;

import finalTestDuy.model.entity.Phone;

import java.util.List;
import java.util.Scanner;

public class PhoneView {
    private final Scanner scanner;

    public PhoneView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nMenu chức năng:");
        System.out.println("1. Add new phone");
        System.out.println("2. Delete phone");
        System.out.println("3. View phone list");
        System.out.println("4. Search phone");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");


    }

    public String getUserChoice() {
        return scanner.nextLine().trim();
    }

    public String getPhoneType() {
        System.out.println("\nAdd new phone:");
        System.out.println("1. Authentic Phone");
        System.out.println("2. Hand Carry Phone");
        System.out.print("Enter phone type: ");
        String type = scanner.nextLine().trim();

        if (!type.equals("1") && !type.equals("2")) {
            displayError("Invalid phone type");
            return null;
        }
        return type;
    }

    public String getPhoneName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name;
    }

    public double getPhonePrice() {
        System.out.print("Enter price: ");
        try {
            double price = Double.parseDouble(scanner.nextLine().trim());
            if (price <= 0) {
                throw new IllegalArgumentException("Price must be positive");
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format");
        }
    }

    public int getPhoneQuantity() {
        System.out.print("Enter quantity: ");
        try {
            int quantity = Integer.parseInt(scanner.nextLine().trim());
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity format");
        }
    }

    public String getPhoneManufacturer() {
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.nextLine().trim();
        if (manufacturer.isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be empty");
        }
        return manufacturer;
    }

    public int getWarrantyTime() {
        System.out.print("Enter warranty time (days): ");
        try {
            int warrantyTime = Integer.parseInt(scanner.nextLine().trim());
            if (warrantyTime <= 0 || warrantyTime > 730) {
                throw new IllegalArgumentException("Warranty time must be between 1 and 730 days");
            }
            return warrantyTime;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid warranty time format");
        }
    }

    public String getWarrantyScope() {
        System.out.print("Enter warranty scope (Toan Quoc/Quoc Te): ");
        String scope = scanner.nextLine().trim();
        if (!scope.equals("Toan Quoc") && !scope.equals("Quoc Te")) {
            throw new IllegalArgumentException("Invalid warranty scope");
        }
        return scope;
    }

    public String getCountryOfOrigin() {
        System.out.print("Enter country of origin: ");
        String country = scanner.nextLine().trim();
        if (country.equalsIgnoreCase("Viet Nam")) {
            throw new IllegalArgumentException("Country of origin cannot be Vietnam");
        }
        return country;
    }

    public String getPhoneCondition() {
        System.out.print("Enter condition (Da sua chua/Chua sua chua): ");
        String condition = scanner.nextLine().trim();
        if (!condition.equals("Da sua chua") && !condition.equals("Chua sua chua")) {
            throw new IllegalArgumentException("Invalid condition");
        }
        return condition;
    }

    public int getPhoneId() {
        System.out.print("\nEnter phone ID to delete: ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid ID format");
        }
    }

    public String getSearchKeyword() {
        System.out.print("\nEnter search keyword: ");
        return scanner.nextLine().trim();
    }

    public void displayPhoneList(List<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("\nNo phones in the system.");
            return;
        }
        System.out.println("\nPhone List:");
        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }

    public void displaySearchResults(List<Phone> results) {
        if (results.isEmpty()) {
            System.out.println("No phones found.");
            return;
        }
        System.out.println("\nSearch Results:");
        for (Phone phone : results) {
            System.out.println(phone);
        }
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void displaySuccessMessage(String message) {
        System.out.println(message);
    }

    public void displayExitMessage() {
        System.out.println("Exiting program...");
    }

    public void displayInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }
}
