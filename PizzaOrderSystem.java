import java.util.Scanner;

public class PizzaOrderSystem {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();
        PizzaMenu pizzaMenu = new PizzaMenu();
        OrderManager orderManager = new OrderManager(orderQueue, pizzaMenu);
        orderManager.startOrderingProcess();
    }
}
