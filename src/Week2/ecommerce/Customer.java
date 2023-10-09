package Week2.ecommerce;

public class Customer {
    private String customerName;

    public void addCustomer() {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void printDetails() {
        System.out.println("Customer Name:  " + customerName);
    }
}
