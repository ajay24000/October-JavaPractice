package Week2.Challenge5;

import java.util.Scanner;
public class Exercise5 {
    public static void main(String[] args) {

        Customer customer = new Customer("John Doe");

        ShoppingCart shoppingCart = createShoppingCart();

        Order order = new Order(customer , shoppingCart);

        order.printData();
    }

    private static ShoppingCart createShoppingCart() {

        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);
        char addMoreProducts;

        do {

            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter product price: ");
            double productPrice = scanner.nextDouble();
            scanner.nextLine();

            Product product = new Product(productName, productPrice);
            shoppingCart.addProduct(product);

            System.out.print("Do you want  add more products? (y/n): ");
            addMoreProducts = scanner.nextLine().charAt(0);

        } while (addMoreProducts == 'y' || addMoreProducts == 'Y');

        return shoppingCart;
    }
}
