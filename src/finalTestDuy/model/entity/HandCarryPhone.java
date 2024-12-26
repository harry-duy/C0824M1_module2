package finalTestDuy.model.entity;

public class HandCarryPhone extends Phone {
    private String countryOfOrigin;
    private String condition;

    public HandCarryPhone() {}

    public HandCarryPhone(int id, String name, double price, int quantity,
                          String manufacturer, String countryOfOrigin, String condition) {
        super(id, name, price, quantity, manufacturer);
        this.countryOfOrigin = countryOfOrigin;
        this.condition = condition;
    }

    // Getters and setters
    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }
    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    @Override
    public String getDetails() {
        return ", Country Of Origin: " + countryOfOrigin + ", Condition: " + condition;
    }

    @Override
    public String toString() {
        return super.toString() + getDetails();
    }
}
