package ss12.s4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                break;
            }
        }
    }

    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void searchProduct(String name) {
        for (Product product : products) {
            if (product.getName().contains(name)) {
                System.out.println(product);
                break;
            }
        }
    }

    public void sortProductsAscending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
    }

    public void sortProductsDescending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice).reversed());
    }
}
