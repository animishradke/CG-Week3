class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManager {
    private Movie head = null;
    private Movie tail = null;

    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        int index = 0;

        while (current.next != null && index < position - 1) {
            current = current.next;
            index++;
        }

        newMovie.next = current.next;
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        newMovie.prev = current;
        current.next = newMovie;
    }

    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }

    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No movies found by director: " + director);
    }

    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    public void updateRating(String title, double newRating) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie: " + title);
                return;
            }
            current = current.next;
        }

        System.out.println("Movie \"" + title + "\" not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        Movie current = head;
        while (current != null) {
            displayMovie(current);
            current = current.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        Movie current = tail;
        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }

    private void displayMovie(Movie movie) {
        System.out.println("Title: " + movie.title);
        System.out.println("Director: " + movie.director);
        System.out.println("Year: " + movie.year);
        System.out.println("Rating: " + movie.rating);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        MovieManager manager = new MovieManager();
        manager.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        manager.addAtBeginning("The Matrix", "Wachowski", 1999, 8.7);
        manager.addAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 1);

        System.out.println("Movies (Forward):");
        manager.displayForward();

        System.out.println("Movies (Reverse):");
        manager.displayReverse();

        System.out.println("\nSearch by Director: Christopher Nolan");
        manager.searchByDirector("Christopher Nolan");

        System.out.println("\nSearch by Rating: 8.7");
        manager.searchByRating(8.7);

        manager.updateRating("The Matrix", 9.0);
        System.out.println("\nMovies after updating The Matrix rating:");
        manager.displayForward();

        manager.removeByTitle("Interstellar");
        System.out.println("\nMovies after removing Interstellar:");
        manager.displayForward();
    }
}