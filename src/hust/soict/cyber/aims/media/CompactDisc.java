package hust.soict.cyber.aims.media;

import hust.soict.cyber.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
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

    @Override
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

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            java.util.Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    System.err.println("ERROR: Cannot play track - " + nextTrack.getTitle() + ". Reason: " + e.getMessage());
                    throw e;
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive");
            throw new PlayerException("ERROR: CD length is non-positive");
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
