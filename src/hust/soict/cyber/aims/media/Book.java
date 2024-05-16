package hust.soict.cyber.aims.media;

import java.util.ArrayList;
import java.util.List;

//public class Book {
//    private int id;
//    private String title;
//    private String category;
//    private float cost;
//    private List<String> authors = new ArrayList<String>();
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public float getCost() {
//        return cost;
//    }
//
//    public void setCost(float cost) {
//        this.cost = cost;
//    }
//
//    public List<String> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<String> authors) {
//        this.authors = authors;
//    }
//
//    public Book(int id, String title, String category, float cost, List<String> authors) {
//        this.id = id;
//        this.title = title;
//        this.category = category;
//        this.cost = cost;
//        this.authors = authors;
//    }
//
//    public void addAuthor(String authorName) {
//        if (!authors.contains(authorName)) {
//            authors.add(authorName);
//        } else {
//            System.out.println("Author already exists.");
//        }
//    }
//
//    public void removeAuthor(String authorName) {
//        if (authors.contains(authorName)) {
//            authors.remove(authorName);
//        } else {
//            System.out.println("Author not found.");
//        }
//    }
//}

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found.");
        }
    }

    @Override
    public String toString() {
        return "Book info:\nID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() +
                ", Cost: " + getCost() + ", Authors: " + String.join(", ", authors);
    }
}