package hust.soict.cyber.aims.store;

import hust.soict.cyber.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int itemCount;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        itemCount = 0;
    }

    public void addDisc(DigitalVideoDisc disc) {
        if (itemCount < itemsInStore.length) {
            itemsInStore[itemCount++] = disc;
        } else {
            System.out.println("Store is full");
        }
    }

    public void removeDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i].equals(disc)) {
                for (int j = i; j < itemCount - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[itemCount - 1] = null;
                itemCount--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("DVD not found in the hust.soict.dsai.store");
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        float totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            DigitalVideoDisc disc = itemsInStore[i];
            System.out.println((i + 1) + ". " + disc.toString()); // Using toString() method
            totalCost += disc.getCost();
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("****************************************************");
    }
}
