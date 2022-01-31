package movietheatres;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie {

    String title;
    LocalTime time;


    public Movie(String title, LocalTime time) {
        this.title = title;
        this.time = time;
    }


    public String getTitle() {
        return title;
    }

    public LocalTime getTime() {
        return time;
    }
}
