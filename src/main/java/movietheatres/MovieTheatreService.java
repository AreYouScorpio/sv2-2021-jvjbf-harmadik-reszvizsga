package movietheatres;


import org.apache.commons.collections.map.LinkedMap;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import static movietheatres.FileReader.FILENAME;

public class MovieTheatreService {
    public Map<String, List<Movie>> movies = new TreeMap<>();

    void readFromFile(Path p){
        FileReader fileReader = new FileReader();
        movies=fileReader.readFile(p);
    }

 public Map<String, List<Movie>> getShows(){
        return movies;

 }


   }

