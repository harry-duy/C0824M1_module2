package finalTest;

class AuthenticPhone extends Phone {
    private int warrantyTime;
    private String warrantyScope;

    public AuthenticPhone() {
    }

    public AuthenticPhone(int id, String name, double price, int quantity, String manufacturer, int warrantyTime, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyTime = warrantyTime;
        this.warrantyScope = warrantyScope;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public String getWarrantyScope() {
        return warrantyScope;
    }

    public void setWarrantyScope(String warrantyScope) {
        this.warrantyScope = warrantyScope;
    }

    @Override
    public String getDetails() {
        return ", Warranty Time: " + warrantyTime + ", Warranty Scope: " + warrantyScope;
    }

    @Override
    public String toString() {
        return super.toString() + getDetails();
    }
}
