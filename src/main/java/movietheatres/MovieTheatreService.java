package movietheatres;


import org.apache.commons.collections.map.LinkedMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;


import static movietheatres.FileReader.FILENAME;

public class MovieTheatreService {
    //private Map<String, List<Movie>> movies = new TreeMap<>();
    private Map<String, List<Movie>> shows = new LinkedHashMap<>();

    /*

    public void readFromFile(Path p){
        FileReader fileReader = new FileReader();
        movies=fileReader.readFile(p);
    }

     */

    public void readFromFile(Path p) {
        try (
                BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }
    }

    private void parseLine(String line) {
        String[] temp = line.split("-");
        String[] movieTemp = temp[1].split(";");
        if (!getShows().containsKey(temp[0])) {
            shows.put(temp[0], new ArrayList<>());
        }
        shows.get(temp[0]).add(new Movie(movieTemp[0], LocalTime.parse(movieTemp[1])));
        // shows.get(temp[0]).stream().sorted(Comparator.comparing(Movie::getStartTime)).toList();
        Collections.sort(shows.get(temp[0]),Comparator.comparing(Movie::getStartTime));
    }

    public Map<String, List<Movie>> getShows() {
        return shows;

    }


    public List<String> findMovie(String title){
        return shows.entrySet().stream().filter(e->e.getValue().stream()
                .anyMatch(m->m.getTitle().equals(title)))
        .map(e->e.getKey()).toList();

    }

    public LocalTime findLatestShow(String title){
    return shows.entrySet().stream().flatMap(e->e.getValue().stream())
            .filter(m->m.getTitle().equals(title))
            .sorted(Comparator.comparing(Movie::getStartTime).reversed()).findFirst()
            .orElseThrow(()-> new IllegalArgumentException("Cannot find movie!")).getStartTime();
    }

}

