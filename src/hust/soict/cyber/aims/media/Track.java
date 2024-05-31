package hust.soict.cyber.aims.media;

import hust.soict.cyber.aims.exception.PlayerException;

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

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        }
        else {
            throw new PlayerException("ERROR: Track length is non-positive");
        }
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
