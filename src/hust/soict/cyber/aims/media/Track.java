package hust.soict.cyber.aims.media;

public class Track {
    private String title;
    private int length;

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Constructors
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
}
