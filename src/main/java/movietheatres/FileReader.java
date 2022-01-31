package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.*;

public class FileReader {


    public static final String FILENAME = "src/main/resources/moviesintheaters.txt";


    public Map<String, List<Movie>> movies = new TreeMap<>();

    public Map<String, List<Movie>> getMovies() {
        return movies;
    }




    public Map<String, List<Movie>> readFile(Path p) throws IllegalStateException {
        try {
            List<String> lines = Files.readAllLines(p);
            int counter = 0;
            for (String line : lines) {
                String s[] = line.split("-");
                String theaterName = s[0];
                s = line.split(";");
                Movie movie = new Movie(s[0], LocalTime.parse(s[1]));
                if (!movies.containsKey(theaterName)) movies.put(theaterName, new ArrayList<>());
                movies.get(theaterName).add(movie);
                movies.get(theaterName).sort(Comparator.comparing(Movie::getTime));
            }

        } catch (
                IOException ise) {
            throw new IllegalStateException("Can't read file!", ise);
        }
        return movies;
    }


}