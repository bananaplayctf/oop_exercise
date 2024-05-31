package hust.soict.cyber.aims.screen;

import hust.soict.cyber.aims.cart.Cart;
import hust.soict.cyber.aims.media.*;

import hust.soict.cyber.aims.media.Media;
import hust.soict.cyber.aims.screen.CartScreen;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Cart
        Cart cart = new Cart(); // You may need to provide constructor parameters if required

        // Create some media items
        Media book = new Book(1, "Java Programming", "Programming", 19.99f);
        Media cd = new CompactDisc(2, "Greatest Hits", "Music",  14.99f, 15, "A", "B");
        Media dvd = new DigitalVideoDisc(3, "Ane Matrix", "Movie", "phamhongquan", 120);

        // Add the media items to the cart
        cart.addMedia(book);
        cart.addMedia(cd);
        cart.addMedia(dvd);

        // Create an instance of CartScreen and pass the Cart instance
        CartScreen cartScreen = new CartScreen(cart);
    }
}
