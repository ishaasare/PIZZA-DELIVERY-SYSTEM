import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<Order> orders;

    public OrderQueue() {
        orders = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order processOrder() {
        return orders.poll();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }

    public int getOrderCount() {
        return orders.size();
    }
}
