package hust.soict.cyber.aims;

import hust.soict.cyber.aims.cart.Cart;
import hust.soict.cyber.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        //Create new dvd objects and add them to the hust.soict.dsai.store.cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        //print total cost of the items in the hust.soict.dsai.store.cart
        System.out.println("Total Cost is: "); 
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println("Total Cost is: "); 
        System.out.println(anOrder.totalCost());

        anOrder.print();
    }
}