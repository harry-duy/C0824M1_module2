package finalTestDuy.Controller;

import finalTestDuy.model.AuthenticPhone;
import finalTestDuy.model.HandCarryPhone;
import finalTestDuy.model.IPhone;
import finalTestDuy.model.NotFoundProductException;
import finalTestDuy.view.PhoneView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class PhoneController {
    private static final String DATA_FILE = "src/finalTestDuy/data/mobiles.csv";
    private List<IPhone> phones = new ArrayList<>();
    private final PhoneView view = new PhoneView();

    public PhoneController() {
        loadData();
    }

    public void run() {
        int choice;
        do {
            view.printMenu();
            choice = view.getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    deletePhone();
                    break;
                case 3:
                    viewPhones();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    view.displayMessage("Exiting...");
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        view.closeScanner();
    }

    private void loadData() {
        phones.clear();
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                System.out.println("Created new data file: " + DATA_FILE);
            } catch (IOException e) {
                System.err.println("Error creating data file: " + e.getMessage());
                return;
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 5) continue;
                int id = Integer.parseInt(values[0]);
                String name = values[1];
                double price = Double.parseDouble(values[2]);
                int quantity = Integer.parseInt(values[3]);
                String manufacturer = values[4];

                if (values.length == 7) {
                    String country = values[5];
                    String status = values[6];
                    phones.add(new HandCarryPhone(id, name, price, quantity, manufacturer, country, status));
                } else if (values.length == 8) {
                    int warrantyPeriod = Integer.parseInt(values[5]);
                    String warrantyScope = values[6];
                    phones.add(new AuthenticPhone(id, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            bw.write("ID,Name,Price,Quantity,Manufacturer,WarrantyPeriod,WarrantyScope\n");
            for (IPhone phone : phones) {
                bw.write(phone.toCSVString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private void addPhone() {
        view.displayMessage("\n--- Add New Phone ---");
        int nextId = phones.isEmpty() ? 1 : phones.get(phones.size() - 1).getId() + 1;
        String name, manufacturer, phoneType;
        double price;
        int quantity;

        while (true) {
            name = view.getInput("Enter phone name: ");
            if (name.isEmpty()) {
                view.displayMessage("Name is required.");
                continue;
            }
            break;
        }

        while (true) {
            price = view.getDoubleInput("Enter phone price: ");
            if (price <= 0) {
                view.displayMessage("Price must be a positive number.");
                continue;
            }
            break;
        }

        while (true) {
            quantity = view.getIntInput("Enter phone quantity: ");
            if (quantity <= 0) {
                view.displayMessage("Quantity must be a positive number.");
                continue;
            }
            break;
        }

        while (true) {
            manufacturer = view.getInput("Enter phone manufacturer: ");
            if (manufacturer.isEmpty()) {
                view.displayMessage("Manufacturer is required.");
                continue;
            }
            break;
        }

        while (true) {
            phoneType = view.getInput("Enter phone type (authentic/handcarry): ").toLowerCase();
            if (!phoneType.equals("authentic") && !phoneType.equals("handcarry")) {
                view.displayMessage("Invalid phone type. Please enter 'authentic' or 'handcarry'.");
                continue;
            }
            break;
        }

        IPhone newPhone;
        if (phoneType.equals("authentic")) {
            int warrantyPeriod;
            String warrantyScope;

            while (true) {
                warrantyPeriod = view.getIntInput("Enter warranty period (days): ");
                if (warrantyPeriod <= 0 || warrantyPeriod > 730) {
                    view.displayMessage("Warranty period must be a positive number not exceeding 730 days.");
                    continue;
                }
                break;
            }

            while (true) {
                warrantyScope = view.getInput("Enter warranty scope (Toan Quoc/Quoc Te): ");
                if (!warrantyScope.equals("Toan Quoc") && !warrantyScope.equals("Quoc Te")) {
                    view.displayMessage("Invalid warranty scope. Please enter 'Toan Quoc' or 'Quoc Te'.");
                    continue;
                }
                break;
            }

            newPhone = new AuthenticPhone(nextId, name, price, quantity, manufacturer, warrantyPeriod, warrantyScope);
        } else {
            String country, status;

            while (true) {
                country = view.getInput("Enter country: ");
                if (country.equalsIgnoreCase("Viet Nam")) {
                    view.displayMessage("Country must not be 'Viet Nam'.");
                    continue;
                }
                if (country.isEmpty()) {
                    view.displayMessage("Country is required.");
                    continue;
                }
                break;
            }

            while (true) {
                status = view.getInput("Enter status (Da sua chua/Chua sua chua): ");
                if (!status.equals("Da sua chua") && !status.equals("Chua sua chua")) {
                    view.displayMessage("Invalid status. Please enter 'Da sua chua' or 'Chua sua chua'.");
                    continue;
                }
                break;
            }

            newPhone = new HandCarryPhone(nextId, name, price, quantity, manufacturer, country, status);
        }

        phones.add(newPhone);
        saveData();
        view.displayMessage("Phone added successfully.");
    }

    private void deletePhone() {
        view.displayMessage("\n--- Delete Phone ---");
        int idToDelete;
        while (true) {
            idToDelete = view.getIntInput("Enter ID of the phone to delete: ");
            boolean found = false;
            for (IPhone phone : phones) {
                if (phone.getId() == idToDelete) {
                    found = true;
                    String confirmation = view.getInput("Are you sure you want to delete phone with ID " + idToDelete + "? (yes/no): ").toLowerCase();
                    if (confirmation.equals("yes")) {
                        phones.remove(phone);
                        saveData();
                        view.displayMessage("Phone with ID " + idToDelete + " deleted successfully.");
                        viewPhones();
                    } else {
                        view.displayMessage("Deletion cancelled.");
                    }
                    break;
                }
            }
            if (!found) {
                try {
                    throw new NotFoundProductException("ID phone does not exist.");
                } catch (NotFoundProductException e) {
                    view.displayMessage(e.getMessage());
                }
            }
            if (found) break;
        }
        view.getInput("Press Enter to return to the main menu.");
    }

    private void viewPhones() {
        view.displayPhones(phones);
    }

    private void searchPhone() {
        view.displayMessage("\n--- Search Phone ---");
        String keyword = view.getInput("Enter search keyword (ID or Name): ").toLowerCase();
        boolean found = false;
        for (IPhone phone : phones) {
            if (String.valueOf(phone.getId()).contains(keyword) || phone.getName().toLowerCase().contains(keyword)) {
                System.out.println(phone);
                found = true;
            }
        }
        if (!found) {
            view.displayMessage("No phones found matching the keyword.");
        }
    }
}
