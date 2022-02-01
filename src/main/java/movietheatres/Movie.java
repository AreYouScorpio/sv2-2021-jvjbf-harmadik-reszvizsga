package movietheatres;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Movie {

    private String title;
    private LocalTime time;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        //return title.equals(movie.title);
        return title!=null ? title.equals(movie.title):movie.title==null;

    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public LocalTime getStartTime() {
        return time;
    }
}
