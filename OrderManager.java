import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderManager {
    private OrderQueue orderQueue;
    private PizzaMenu pizzaMenu;
    private Scanner scanner;

    public OrderManager(OrderQueue orderQueue, PizzaMenu pizzaMenu) {
        this.orderQueue = orderQueue;
        this.pizzaMenu = pizzaMenu;
        this.scanner = new Scanner(System.in);
    }

    public void startOrderingProcess() {
        while (true) {
            System.out.println("\n1. Place an Order");
            System.out.println("2. Process an Order");
            System.out.println("3. View Pending Orders");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidIntInput();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    processOrder();
                    break;
                case 3:
                    viewPendingOrders();
                    break;
                case 4:
                    System.out.println("Thank you for using the Pizza Order System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void placeOrder() {
        try {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter delivery address: ");
            String deliveryAddress = scanner.nextLine();

            pizzaMenu.displayMenu();
            System.out.print("Choose a pizza by ID: ");
            int pizzaId = getValidIntInput();

            Pizza pizza = pizzaMenu.getPizza(pizzaId);

            System.out.print("Enter quantity: ");
            int quantity = getValidIntInput();

            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero.");
                return;
            }

            Order order = new Order(pizza, quantity, customerName, deliveryAddress);
            orderQueue.addOrder(order);
            System.out.println("Order placed successfully! Order details: " + order);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void processOrder() {
        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders to process.");
        } else {
            Order processedOrder = orderQueue.processOrder();
            System.out.println("Processing order: " + processedOrder);
        }
    }

    private void viewPendingOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No pending orders.");
        } else {
            System.out.println("Pending orders count: " + orderQueue.getOrderCount());
        }
    }

    private int getValidIntInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
