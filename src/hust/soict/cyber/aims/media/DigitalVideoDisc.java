package hust.soict.cyber.aims.media;

import java.util.Objects;


public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(int id, String title) {
        super(id, title, "", 0.0f, 0, "");
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost, 0, "");
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, cost, 0, director);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public boolean isequal(DigitalVideoDisc disc) {
        return this.getTitle().equals(disc.getTitle())
                && this.getCategory().equals(disc.getCategory())
                && this.getCost() == disc.getCost()
                && Objects.equals(this.getDirector(), disc.getDirector())
                && this.getLength() == disc.getLength();
    }

    @Override
    public String toString() {
        return "DVD info:\nID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() +
                ", Cost: $" + getCost() + ", Director: " + getDirector() + ", Length: " + getLength() + " minutes";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}