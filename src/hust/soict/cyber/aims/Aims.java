package hust.soict.cyber.aims;

import hust.soict.cyber.aims.media.*;
import hust.soict.cyber.aims.store.Store;
import hust.soict.cyber.aims.cart.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static int nbBook = 0;
    private static int nbCD = 0;
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    public static void viewStore() {
        while (true) {
            System.out.println("Store items:");
            List<Media> mediaList = store.getItemsInStore();
            for (Media media : mediaList) {
                System.out.println(media);
            }

            storeMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            System.out.println(media);
            if (media instanceof Book book) {
                System.out.println(book);
            } else if (media instanceof CompactDisc cd) {
                System.out.println(cd);
            } else if (media instanceof DigitalVideoDisc dvd) {
                System.out.println(dvd);
            }
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added to cart. Current number of items in cart: " + cart.getItemsOrdered().size());
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played!");
        }
    }

    public static void updateStore() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    public static void addMediaToStore() {
        System.out.print("Enter media type (Book/CD/DVD): ");
        String type = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();
        System.out.print("Enter length: ");
        int length = scanner.nextInt();
        System.out.print("Enter director/author: ");
        String director = scanner.nextLine();
        scanner.nextLine();

        Media media;
        if (type.equalsIgnoreCase("Book")) {
            List<String> authors = new ArrayList<>();
            authors.add(director);
            media = new Book(nbBook, title, category, cost, authors);
            nbBook++;
        } else if (type.equalsIgnoreCase("CD")) {
            media = new CompactDisc(nbCD, title, category, cost, 0, "", "");
            nbCD++;
        } else if (type.equalsIgnoreCase("DVD")) {
            media = new DigitalVideoDisc(title, category, cost, length, director);
        } else {
            System.out.println("Invalid media type!");
            return;
        }

        store.addMedia(media);
        System.out.println("Media added to store.");
    }

    public static void removeMediaFromStore() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void seeCurrentCart() {
        while (true) {
            System.out.println("Current cart items:");
            List<Media> mediaList = cart.getItemsOrdered();
            for (Media media : mediaList) {
                System.out.println(media);
            }

            cartMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    System.out.println("Not available function");
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    System.out.println("Not available function");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediasInCart() {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                cart.filterById(id);
                break;
            case 2:
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                cart.filterByTitle(title);
                break;
            default:
                System.out.println("Invalid choice! Please choose again.");
        }
    }

    public static void sortMediasInCart() {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid choice! Please choose again.");
        }
    }

    public static void playMediaInCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played!");
        }
    }

}
