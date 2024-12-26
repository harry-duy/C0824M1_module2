package finalTestDuy.model;

public class HandCarryPhone extends Phone {
    private String country;
    private String status;

    public HandCarryPhone(int id, String name, double price, int quantity, String manufacturer, String country, String status) {
        super(id, name, price, quantity, manufacturer);
        this.country = country;
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Country: %s, Status: %s", country, status);
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + String.format(",%s,%s", country, status);
    }
}
