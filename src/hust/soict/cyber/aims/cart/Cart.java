package hust.soict.cyber.aims.cart;

import hust.soict.cyber.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.Collections;

import static hust.soict.cyber.aims.media.Media.COMPARE_BY_COST_TITLE;
import static hust.soict.cyber.aims.media.Media.COMPARE_BY_TITLE_COST;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private FilteredList<Media> filteredItems;

    public Cart() {
        filteredItems = new FilteredList<>(itemsOrdered, p -> true);
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        } else {
            System.out.println("Maximum order reached");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not found in the cart");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". " + media.toString()); // Using toString() method
            totalCost += media.getCost();
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("***************************************************");
    }

    public void searchMediaByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                found = true;
                System.out.println(media);
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    public void searchMediaByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                found = true;
                System.out.println(media);
            }
        }
        if (!found) {
            System.out.println("No match found for Title: " + title);
        }
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public FilteredList<Media> getFilteredItems() {
        return filteredItems;
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost.");
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void filterById(int id) {
        filteredItems.setPredicate(media -> media.getId() == id);
    }

    public void filterByTitle(String title) {
        filteredItems.setPredicate(media -> media.getTitle().equalsIgnoreCase(title));
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("Cart cleared.");
    }
}
