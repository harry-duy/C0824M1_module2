package finalTestDuy.model.repository;


import finalTestDuy.model.entity.AuthenticPhone;
import finalTestDuy.model.entity.HandCarryPhone;
import finalTestDuy.model.entity.Phone;

import java.util.*;
import java.io.*;

public class PhoneRepository {
    private static final String DATA_FILE = "src/finalTestDuy/data/mobiles.csv";
    private List<Phone> phones;
    private int nextId;

    public PhoneRepository() {
        phones = new ArrayList<>();
        nextId = 1;
        loadData();
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    int quantity = Integer.parseInt(parts[3].trim());
                    String manufacturer = parts[4].trim();
                    String type = parts[5].trim();

                    if ("authentic".equalsIgnoreCase(type) && parts.length == 8) {
                        int warrantyTime = Integer.parseInt(parts[6].trim());
                        String warrantyScope = parts[7].trim();
                        phones.add(new AuthenticPhone(id, name, price, quantity,
                                manufacturer, warrantyTime, warrantyScope));
                    } else if ("handcarry".equalsIgnoreCase(type) && parts.length == 8) {
                        String countryOfOrigin = parts[6].trim();
                        String condition = parts[7].trim();
                        phones.add(new HandCarryPhone(id, name, price, quantity,
                                manufacturer, countryOfOrigin, condition));
                    }
                    nextId = Math.max(nextId, id + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            bw.write("ID,Name,Price,Quantity,Manufacturer,Type,WarrantyTime/Origin,WarrantyScope/Condition\n");
            for (Phone phone : phones) {
                String line = String.format("%d,%s,%.2f,%d,%s,",
                        phone.getId(), phone.getName(), phone.getPrice(),
                        phone.getQuantity(), phone.getManufacturer());

                if (phone instanceof AuthenticPhone) {
                    AuthenticPhone ap = (AuthenticPhone) phone;
                    line += String.format("authentic,%d,%s",
                            ap.getWarrantyTime(), ap.getWarrantyScope());
                } else if (phone instanceof HandCarryPhone) {
                    HandCarryPhone hp = (HandCarryPhone) phone;
                    line += String.format("handcarry,%s,%s",
                            hp.getCountryOfOrigin(), hp.getCondition());
                }
                bw.write(line + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public void addPhone(Phone phone) {
        phone.setId(nextId++);
        phones.add(phone);
        saveData();
    }

    public void deletePhone(int id) throws Exception {
        boolean removed = phones.removeIf(p -> p.getId() == id);
        if (!removed) {
            throw new Exception("Phone not found with ID: " + id);
        }
        saveData();
    }

    public List<Phone> getAllPhones() {
        return new ArrayList<>(phones);
    }

    public List<Phone> searchPhones(String keyword) {
        keyword = keyword.toLowerCase();
        List<Phone> results = new ArrayList<>();
        for (Phone phone : phones) {
            if (String.valueOf(phone.getId()).contains(keyword) ||
                    phone.getName().toLowerCase().contains(keyword)) {
                results.add(phone);
            }
        }
        return results;
    }
}
