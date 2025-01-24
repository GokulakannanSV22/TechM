package com.streamapiprograms.app;

import java.util.*;
import java.util.stream.*;

class Movie {
    private String title;
    private String genre;
    private double rating;
    private int releaseYear;

    public Movie(String title, String genre, double rating, int releaseYear) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}

public class MovieRecomendationSystem {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("The Matrix", "Sci-Fi", 8.7, 1999),
                new Movie("Inception", "Sci-Fi", 8.8, 2010),
                new Movie("Gladiator", "Action", 8.5, 2000),
                new Movie("The Shawshank Redemption", "Drama", 9.3, 1994),
                new Movie("The Dark Knight", "Action", 9.0, 2008),
                new Movie("The Godfather", "Drama", 9.2, 1972)
        );

        
        List<Movie> filteredMovies = movies.stream()
                .filter(movie -> movie.getReleaseYear() >= 2000)
                .collect(Collectors.toList());

       
        Map<String, List<Movie>> moviesByGenre = filteredMovies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        
        Map<String, Double> averageRatingsByGenre = moviesByGenre.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Movie::getRating)
                                .average()
                                .orElse(0.0)
                ));

        
        Map.Entry<String, Double> highestRatedGenre = averageRatingsByGenre.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        
        if (highestRatedGenre != null) {
            System.out.println("Genre with the highest average rating: " + highestRatedGenre.getKey() + ", Average Rating: " + highestRatedGenre.getValue());
        } else {
            System.out.println("No genre found.");
        }
    }
}
