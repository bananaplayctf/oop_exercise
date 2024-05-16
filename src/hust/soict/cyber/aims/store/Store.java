package hust.soict.cyber.aims.store;

import hust.soict.cyber.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Media item not found in the store");
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            Media media = itemsInStore.get(i);
            System.out.println((i + 1) + ". " + media.toString()); // Using toString() method
        }
        System.out.println("****************************************************");
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}
