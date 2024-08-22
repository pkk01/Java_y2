import java.util.ArrayList;
import java.util.Collections;

class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public int compareTo(Movie m) {
        return this.year - m.year;
    }

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    public String getName() {
        return this.name;
    }

    public double getRating() {
        return this.rating;
    }
}

public class ComparableMain {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<>();
        list.add(new Movie("Anand", 8.7, 1971));
        list.add(new Movie("Drishyam", 8.6, 2013));
        list.add(new Movie("Nayakan", 8.7, 1987));
        list.add(new Movie("Dangal", 8.5, 2016));

        Collections.sort(list);
        System.out.println("Movies after sorting based on year of release");
        for (Movie m : list) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }
        System.out.println("Movies after sorting based on the rating");
        for (Movie m : list) {
            System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
        }

    }
}
