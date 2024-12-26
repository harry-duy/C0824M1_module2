package finalTestDuy.model;


public interface IPhone {
    int getId();
    String getName();
    double getPrice();
    int getQuantity();
    String getManufacturer();
    String toCSVString();
    String toString();
}
