package movietheatres;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileReader {

    public static final String FILENAME = "src/main/resources/moviesintheaters.txt";


    public Map<String, List<Movie>> movies = new TreeMap<>();

    public Map<String, List<Movie>> getMovies() {
        return movies;
    }



    // public List<String> players = new ArrayList<>();
    // List<String> answers = new ArrayList<>();
    public String movie;


    public void readFile(Path p) throws IllegalStateException {
        try {
            List<String> lines = Files.readAllLines(p);
            int counter = 0;
            for (String line : lines) {
                if (counter == 0) {
                    movie = line;
                    System.out.println(movie);
                    counter = 1;
                } else {

                    String s[] = line.split(";");
                    if (!movies.containsKey(s[0])) movies.put(s[0], new ArrayList<>());
                    movies.get(s[0]).add(s[1]);
                    System.out.println(movies);

                }
            }

        } catch (
                IOException ise) {
            throw new IllegalStateException("Can't read file!", ise);
        }
    }


}