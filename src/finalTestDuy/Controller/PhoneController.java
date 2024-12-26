package finalTestDuy.Controller;


import finalTestDuy.model.entity.Phone;
import finalTestDuy.model.service.PhoneService;
import finalTestDuy.view.PhoneView;

import java.util.List;

public class PhoneController {
    private final PhoneService phoneService;
    private final PhoneView phoneView;

    public PhoneController() {
        this.phoneService = new PhoneService();
        this.phoneView = new PhoneView();
    }

    public void processUserChoice(String choice) {
        try {
            switch (choice) {
                case "1":
                    handleAddPhone();
                    break;
                case "2":
                    handleDeletePhone();
                    break;
                case "3":
                    handleViewPhones();
                    break;
                case "4":
                    handleSearchPhones();
                    break;
                case "5":
                    phoneView.displayExitMessage();
                    System.exit(0);
                    break;
                default:
                    phoneView.displayInvalidChoice();
            }
        } catch (Exception e) {
            phoneView.displayError(e.getMessage());
        }
    }

    private void handleAddPhone() {
        String type = phoneView.getPhoneType();

        if (type == null) {
            return;
        }

        try {
            String name = phoneView.getPhoneName();
            double price = phoneView.getPhonePrice();
            int quantity = phoneView.getPhoneQuantity();
            String manufacturer = phoneView.getPhoneManufacturer();

            if ("1".equals(type)) {
                int warrantyTime = phoneView.getWarrantyTime();
                String warrantyScope = phoneView.getWarrantyScope();

                phoneService.addAuthenticPhone(name, price, quantity,
                        manufacturer, warrantyTime, warrantyScope);
            } else if ("2".equals(type)) {
                String countryOfOrigin = phoneView.getCountryOfOrigin();
                String condition = phoneView.getPhoneCondition();

                phoneService.addHandCarryPhone(name, price, quantity,
                        manufacturer, countryOfOrigin, condition);
            }

            phoneView.displaySuccessMessage("Phone added successfully!");
        } catch (IllegalArgumentException e) {
            phoneView.displayError(e.getMessage());
        }
    }

    private void handleDeletePhone() {
        try {
            int id = phoneView.getPhoneId();
            phoneService.deletePhone(id);
            phoneView.displaySuccessMessage("Phone deleted successfully!");
        } catch (Exception e) {
            phoneView.displayError(e.getMessage());
        }
    }

    private void handleViewPhones() {
        List<Phone> phones = phoneService.getAllPhones();
        phoneView.displayPhoneList(phones);
    }

    private void handleSearchPhones() {
        String keyword = phoneView.getSearchKeyword();
        List<Phone> results = phoneService.searchPhones(keyword);
        phoneView.displaySearchResults(results);
    }

    public void start() {
        while (true) {
            phoneView.displayMenu();
            String choice = phoneView.getUserChoice();
            processUserChoice(choice);
        }
    }
}
