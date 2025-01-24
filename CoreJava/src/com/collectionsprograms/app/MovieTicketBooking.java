package com.collectionsprograms.app;

import java.util.*;

class Movie 
{
    String title;
    String language;
    String genre;
    List<String> shows;

    public Movie(String title, String language, String genre, List<String> shows)
    {
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.shows = shows;
    }

    public String toString() 
    {
        return "Movie: " + title + " | Language: " + language + " | Genre: " + genre + " | Shows: " + shows;
    }
}

class BookingSystem 
{
    private LinkedList<Movie> movieList = new LinkedList<>();
    private Map<String, List<String>> bookings = new HashMap<>(); // Key: Show, Value: Booked Seats

    // Add a movie
    public void addMovie(Movie movie) 
    {
        movieList.add(movie);
    }

    // List all movies
    public void listMovies()
    {
        if (movieList.isEmpty())
        {
            System.out.println("No movies available.");
        } else
        {
            for (int i = 0; i < movieList.size(); i++) 
            {
                System.out.println((i + 1) + ". " + movieList.get(i));
            }
        }
    }

    // Search for a movie by title
    public void searchMovie(String title) 
    {
        boolean found = false;
        for (Movie movie : movieList)
        {
            if (movie.title.equalsIgnoreCase(title))
            {
                System.out.println(movie);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("Movie not found!");
        }
    }

    // Book a ticket
    public void bookTicket(String movieTitle, String showTime, String seat) {
        Movie selectedMovie = null;

        // Find the movie
        for (Movie movie : movieList) 
        {
            if (movie.title.equalsIgnoreCase(movieTitle)) 
            {
                selectedMovie = movie;
                break;
            }
        }

        if (selectedMovie == null)
        {
            System.out.println("Movie not found!");
            return;
        }

        // Check if the show exists
        if (!selectedMovie.shows.contains(showTime)) 
        {
            System.out.println("Show not found!");
            return;
        }

        // Add the booking
        bookings.putIfAbsent(showTime, new ArrayList<>());
        List<String> bookedSeats = bookings.get(showTime);

        if (bookedSeats.contains(seat)) 
        {
            System.out.println("Seat already booked!");
        } else 
        {
            bookedSeats.add(seat);
            System.out.println("Seat " + seat + " booked successfully for " + movieTitle + " at " + showTime);
        }
    }

    // Display booked seats for a show
    public void displayBookedSeats(String showTime) 
    {
        List<String> bookedSeats = bookings.get(showTime);
        if (bookedSeats == null || bookedSeats.isEmpty())
        {
            System.out.println("No seats booked for this show.");
        }
        else 
        {
            System.out.println("Booked seats for " + showTime + ": " + bookedSeats);
        }
    }
}

public class MovieTicketBooking 
{
    public static void main(String[] args) 
    {
        BookingSystem M1 = new BookingSystem();

        // Adding sample movies
        M1.addMovie(new Movie("Avengers: Endgame", "English", "Action", Arrays.asList("10:00 AM", "1:00 PM", "4:00 PM")));
        M1.addMovie(new Movie("Spider-Man: No Way Home", "English", "Action", Arrays.asList("11:00 AM", "2:00 PM", "5:00 PM")));

        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\n--- Online Movie Ticket Booking System ---");
            System.out.println("1. List Movies");
            System.out.println("2. Search Movie");
            System.out.println("3. Book Ticket");
            System.out.println("4. Display Booked Seats");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1:
                    M1.listMovies();
                    break;
                case 2:
                    System.out.print("Enter movie title to search: ");
                    String title = scanner.nextLine();
                    M1.searchMovie(title);
                    break;
                case 3:
                    System.out.print("Enter movie title: ");
                    String movieTitle = scanner.nextLine();
                    System.out.print("Enter show time: ");
                    String showTime = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    String seat = scanner.nextLine();
                    M1.bookTicket(movieTitle, showTime, seat);
                    break;
                case 4:
                    System.out.print("Enter show time to view booked seats: ");
                    String show = scanner.nextLine();
                    M1.displayBookedSeats(show);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

