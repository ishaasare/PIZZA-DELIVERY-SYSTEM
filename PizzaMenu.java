import java.util.HashMap;
import java.util.Map;

public class PizzaMenu {
    private Map<Integer, Pizza> menu;

    public PizzaMenu() {
        menu = new HashMap<>();
        menu.put(1, new Pizza("Margherita", 150));
        menu.put(2, new Pizza("Pepperoni", 200));
        menu.put(3, new Pizza("BBQ Chicken", 250));
        menu.put(4, new Pizza("Veggie Delight", 180));
    }

    public void displayMenu() {
        System.out.println("Pizza Menu:");
        for (Map.Entry<Integer, Pizza> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + " - Rs. " + entry.getValue().getPrice());
        }
    }

    public Pizza getPizza(int pizzaId) {
        if (!menu.containsKey(pizzaId)) {
            throw new IllegalArgumentException("Invalid Pizza ID");
        }
        return menu.get(pizzaId);
    }
}
