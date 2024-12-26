package finalTestDuy.model;

public class AuthenticPhone extends Phone {
    private int warrantyPeriod;
    private String warrantyScope;

    public AuthenticPhone(int id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Warranty Period: %d, Warranty Scope: %s", warrantyPeriod, warrantyScope);
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + String.format(",%d,%s", warrantyPeriod, warrantyScope);
    }
}
