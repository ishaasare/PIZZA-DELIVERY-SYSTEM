public class Order {
    private Pizza pizza;
    private int quantity;
    private String customerName;
    private String deliveryAddress;

    public Order(Pizza pizza, int quantity, String customerName, String deliveryAddress) {
        this.pizza = pizza;
        this.quantity = quantity;
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int calculateTotal() {
        return pizza.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizza=" + pizza.getName() +
                ", quantity=" + quantity +
                ", customerName='" + customerName + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", total=" + calculateTotal() +
                '}';
    }
}
