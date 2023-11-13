package com.example.unstructureddatabasecomparator.model;

public class Rating {
    public String userId;
    public String movieId;
    public String rating;
    public String timestamp;

    public Rating() {
    }

    public Rating(String userId, String movieId, String rating, String timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.timestamp = timestamp;
    }
}
