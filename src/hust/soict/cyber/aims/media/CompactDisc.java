package hust.soict.cyber.aims.media;

import java.util.ArrayList;
import java.util.Objects;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String artist, String director) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Already in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track add: " + track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track remove: " + track);
        } else {
            System.out.println("Not in the list.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void listTracks() {
        for (Track track : tracks) {
            System.out.println(track);
        }
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder tracksInfo = new StringBuilder();
        for (Track track : tracks) {
            tracksInfo.append(track.toString()).append("\n");
        }
        return "CompactDisc info: \nID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() +
                ", Cost: " + getCost() + ", Artist: " + getArtist() + ", Director: " + getDirector() +
                ", Length: " + getLength() + "\nTracks:\n" + tracksInfo.toString();
    }
}
