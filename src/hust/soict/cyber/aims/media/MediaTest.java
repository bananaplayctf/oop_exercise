package hust.soict.cyber.aims.media;

import hust.soict.cyber.aims.media.Book;
import hust.soict.cyber.aims.media.CompactDisc;
import hust.soict.cyber.aims.media.DigitalVideoDisc;
import hust.soict.cyber.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaTest {
//    public static void main(String[] args) {
//        ArrayList<Media> mediaList = new ArrayList<>();
//        mediaList.add(new Book(1, "A", "Novel", 1.0f, Collections.singletonList("Mr.A")));
//        mediaList.add(new CompactDisc(2, "B", "Pop", 15.0f, 0, "Mr.B1", "Mr.B2"));
//        mediaList.add(new DigitalVideoDisc("C", "Sci-Fi", 0.0f, 15, "Mr.C"));
//
//        for (Media media : mediaList) {
//            System.out.println(media.toString());
//        }
//    }

    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();
        mediaList.add(new Book(1, "The Great Gatsby", "Novel", 10.99f));
        mediaList.add(new Book(2, "The Great Gatsby", "Novel", 12.99f));
        mediaList.add(new Book(3, "1984", "Dystopian", 8.99f));
        mediaList.add(new Book(4, "Animal Farm", "Dystopian", 8.99f));

        // Sort by title and then by cost
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title then cost:");
        for (Media media : mediaList) {
            System.out.println(media);
        }

        // Sort by cost and then by title
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\n\nSorted by cost then title:");
        for (Media media : mediaList) {
            System.out.println(media);
        }
    }
}
