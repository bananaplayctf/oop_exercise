package hust.soict.cyber.aims.screen;

import hust.soict.cyber.aims.cart.Cart;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Cart
        Cart cart = new Cart(); // You may need to provide constructor parameters if required

        // Create an instance of CartScreen and pass the Cart instance
        CartScreen cartScreen = new CartScreen(cart);
    }
}
