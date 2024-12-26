package finalTestDuy.model.service;


import finalTestDuy.model.entity.AuthenticPhone;
import finalTestDuy.model.entity.HandCarryPhone;
import finalTestDuy.model.entity.Phone;
import finalTestDuy.model.repository.PhoneRepository;

import java.util.List;

public class PhoneService {
    private final PhoneRepository repository;

    public PhoneService() {
        repository = new PhoneRepository();
    }

    public void addAuthenticPhone(String name, double price, int quantity,
                                  String manufacturer, int warrantyTime, String warrantyScope)
            throws IllegalArgumentException {
        validateCommonFields(name, price, quantity, manufacturer);
        if (warrantyTime <= 0 || warrantyTime > 730) {
            throw new IllegalArgumentException("Warranty time must be between 1 and 730 days");
        }
        if (!warrantyScope.equals("Toan Quoc") && !warrantyScope.equals("Quoc Te")) {
            throw new IllegalArgumentException("Invalid warranty scope");
        }

        AuthenticPhone phone = new AuthenticPhone(0, name, price, quantity,
                manufacturer, warrantyTime, warrantyScope);
        repository.addPhone(phone);
    }

    public void addHandCarryPhone(String name, double price, int quantity,
                                  String manufacturer, String countryOfOrigin, String condition)
            throws IllegalArgumentException {
        validateCommonFields(name, price, quantity, manufacturer);
        if (countryOfOrigin.equalsIgnoreCase("Viet Nam")) {
            throw new IllegalArgumentException("Country of origin cannot be Vietnam");
        }
        if (!condition.equals("Da sua chua") && !condition.equals("Chua sua chua")) {
            throw new IllegalArgumentException("Invalid condition");
        }

        HandCarryPhone phone = new HandCarryPhone(0, name, price, quantity,
                manufacturer, countryOfOrigin, condition);
        repository.addPhone(phone);
    }

    private void validateCommonFields(String name, double price, int quantity, String manufacturer) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Manufacturer cannot be empty");
        }
    }

    public void deletePhone(int id) throws Exception {
        repository.deletePhone(id);
    }

    public List<Phone> getAllPhones() {
        return repository.getAllPhones();
    }

    public List<Phone> searchPhones(String keyword) {
        return repository.searchPhones(keyword);
    }
}
