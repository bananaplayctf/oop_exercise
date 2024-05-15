package hust.soict.cyber.aims.media;

import java.util.Objects;

//public class DigitalVideoDisc {
//    private String title;
//    private String category;
//    private String director;
//    private int length;
//    private float cost;
//    private int id;
//    private static int nbDigitalVideoDiscs = 0;
//
//    public DigitalVideoDisc(String title) {
//        this.title = title;
//        this.id = nbDigitalVideoDiscs;
//        nbDigitalVideoDiscs++;
//    }
//
//    public DigitalVideoDisc(String title, String category, float cost) {
//        this.title = title;
//        this.category = category;
//        this.cost = cost;
//        this.id = nbDigitalVideoDiscs;
//        nbDigitalVideoDiscs++;
//    }
//
//    public DigitalVideoDisc(String title, String category, String director, float cost) {
//        this.title = title;
//        this.category = category;
//        this.director = director;
//        this.cost = cost;
//        this.id = nbDigitalVideoDiscs;
//        nbDigitalVideoDiscs++;
//    }
//
//    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
//        this.title = title;
//        this.category = category;
//        this.director = director;
//        this.length = length;
//        this.cost = cost;
//        this.id = nbDigitalVideoDiscs;
//        nbDigitalVideoDiscs++;
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
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public int getLength() {
//        return length;
//    }
//
//    public void setLength(int length) {
//        this.length = length;
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
//    public float getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public boolean isequal(DigitalVideoDisc disc) {
//        if (this.title != disc.title
//        || !Objects.equals(this.category, disc.category)
//        || this.cost != disc.cost
//        || this.director != disc.director
//        || this.length != disc.length) {
//            return false;
//        }
//        else return true;
//    }
//    @Override
//    public String toString() {
//        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " minutes: $" + cost;
//    }
//}

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;

    private int id;
    private static int nbDigitalVideoDiscs = 0;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public DigitalVideoDisc(String title) {
        super(nbDigitalVideoDiscs, title, "", 0.0f);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isequal(DigitalVideoDisc disc) {
        return this.getTitle().equals(disc.getTitle())
            && this.getCategory().equals(disc.getCategory())
            && this.getCost() == disc.getCost()
            && Objects.equals(this.director, disc.director)
            && this.length == disc.length;
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + " minutes: $" + getCost();
    }
}