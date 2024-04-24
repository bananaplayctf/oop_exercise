package store.Store;

import disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int itemCount;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        itemCount = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (itemCount < itemsInStore.length) {
            itemsInStore[itemCount++] = dvd;
        } else {
            System.out.println("store.Store.Store is full");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < itemCount; i++) {
            if (itemsInStore[i].equals(dvd)) {
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
            System.out.println("DVD not found in the store");
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
