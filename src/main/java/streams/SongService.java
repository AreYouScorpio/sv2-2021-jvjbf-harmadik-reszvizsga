package streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SongService {

    private List<Song> songs = new ArrayList<>();


    // public SongService() {
    //    this.songs = new ArrayList<>();
    // }


    public void addSong(Song s) {
        songs.add(s);
    }


    // public SongService(List<Song> songs) {
    //    this.songs = songs;
    // }


    public Optional<Song> shortestSong() {
        int songLength = songs.stream().mapToInt(s -> s.getLength()).min().getAsInt();
        return songs.stream().filter(s -> s.getLength() == songLength).findFirst();
    }

    public List<Song> findSongByTitle(String title) {
        return songs.stream().filter(s -> s.getTitle() == title).toList();
    }

    public boolean isPerformerInSong(Song s, String performer) {
        return s.getPerformers().stream().anyMatch(p -> p.equals(performer));
    }

    public List<String> titlesBeforeDate(LocalDate date) {
        return songs.stream().filter(s -> s.getRelease().isBefore(date)).map(s -> s.getTitle()).toList();
    }

}
