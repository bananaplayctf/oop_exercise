package hust.soict.cyber.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }


    @Override
    public String toString() {
        return "Book info:\nID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() +
                ", Cost: " + getCost();
    }
}