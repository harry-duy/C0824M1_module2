package ss12.s4;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        Product product1 = new Product(1, "Product 1", 100.0);
        Product product2 = new Product(2, "Product 2", 200.0);
        Product product3 = new Product(3, "Product 3", 300.0);

        productManager.addProduct(product1);
        productManager.addProduct(product2);
        productManager.addProduct(product3);

        System.out.println("Danh sách sản phẩm:");
        productManager.displayProducts();

        productManager.updateProduct(2, new Product(2, "Product 2 updated", 250.0));
        System.out.println("Danh sách sản phẩm sau khi cập nhật:");
        productManager.displayProducts();

        productManager.deleteProduct(3);
        System.out.println("Danh sách sản phẩm sau khi xóa:");
        productManager.displayProducts();

        productManager.searchProduct("Product 1");
        productManager.sortProductsAscending();
        System.out.println("Danh sách sản phẩm sau khi sắp xếp tăng dần:");
        productManager.displayProducts();

        productManager.sortProductsDescending();
        System.out.println("Danh sách sản phẩm sau khi sắp xếp giảm dần:");
        productManager.displayProducts();
    }
}
