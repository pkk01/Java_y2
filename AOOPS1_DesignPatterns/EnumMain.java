import java.util.*;

public class EnumMain {
    enum Movie {
        Extraction, Kalki, Devara, OG, Pushpa
    }

    public static void main(String[] args) {
        Set<Movie> en = EnumSet.of(Movie.Devara, Movie.Extraction, Movie.Kalki, Movie.OG);
        System.out.println("List of Movies: " + en);
    }
}
