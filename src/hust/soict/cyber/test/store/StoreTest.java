package hust.soict.cyber.test.store;

import hust.soict.cyber.aims.store.Store;
import hust.soict.cyber.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(100);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        store.addDisc(dvd1);
        store.addDisc(dvd2);
        store.addDisc(dvd3);

        store.removeDisc(dvd1);

        for (int i = 0; i < 10; i++) {
            DigitalVideoDisc dvd = new DigitalVideoDisc("DVD " + (i + 3), "Category " + (i + 3), 15.0f);
            store.addDisc(dvd);
        }

        store.print();
    }
}
