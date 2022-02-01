package streams;

import java.time.LocalDate;
import java.util.List;

public class Song {

    private String title;
    private int length;
    private List<String> artists;
    private LocalDate date;


    public Song(String title, int length, List<String> artists, LocalDate date) {
        this.title = title;
        this.length = length;
        this.artists = artists;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getPerformers() {
        return artists;
    }

    public LocalDate getRelease() {
        return date;
    }
}
