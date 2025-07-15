import java.util.Stack;

public class FruitBasket {

    private Stack<String> basket;

    public FruitBasket() {
        basket = new Stack<>();
    }


    public void addFruit(String fruit) {
        basket.push(fruit);
        System.out.println(fruit + " added to the basket.");
    }

    public void removeFruit() {
        if (basket.isEmpty()) {
            System.out.println("Basket is empty. No fruit to remove.");
        } else {
            String removed = basket.pop();
            System.out.println(removed + " removed from the basket.");
        }
    }


    public void peekTopFruit() {
        if (basket.isEmpty()) {
            System.out.println("Basket is empty. No fruit on top.");
        } else {
            System.out.println("Top fruit: " + basket.peek());
        }
    }


    public boolean isBasketEmpty() {
        return basket.isEmpty();
    }


    public void displayFruits() {
        if (basket.isEmpty()) {
            System.out.println("The basket is empty.");
        } else {
            System.out.println("\n🍇 Fruits in the basket (Top to Bottom):");
            for (int i = basket.size() - 1; i >= 0; i--) {
                System.out.println(basket.get(i));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FruitBasket vendorBasket = new FruitBasket();

        
        vendorBasket.addFruit("Apple");
        vendorBasket.addFruit("Banana");
        vendorBasket.addFruit("Mango");


        vendorBasket.peekTopFruit();

        vendorBasket.displayFruits();

        vendorBasket.removeFruit();

        vendorBasket.displayFruits();

        System.out.println("Is the basket empty? " + vendorBasket.isBasketEmpty());
    }
}
