package hust.soict.cyber.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Track track = (Track) o;
        if (length != track.length) return false;
        return title.equals(track.title);
    }

    @Override
    public String toString() {
        return "Track: Title: " + title + ", Length: " + length;
    }
}
