package Week2.ecommerce;

import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void printData() {
        System.out.println("Shopping Cart Items: ");
        for (Product product : products) {
            product.printData();
            System.out.println();
        }
    }

}
