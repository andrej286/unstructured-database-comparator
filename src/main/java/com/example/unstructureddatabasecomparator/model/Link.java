package com.example.unstructureddatabasecomparator.model;

public class Link {
    public String movieId;
    public String imdbId;
    public String tmdbId;

    public Link() {
    }

    public Link(String movieId, String imdbId, String tmdbId) {
        this.movieId = movieId;
        this.imdbId = imdbId;
        this.tmdbId = tmdbId;
    }
}
