package com.example.unstructureddatabasecomparator.model.MovieMetaData;

import java.util.Date;
import java.util.List;

public class MovieMetadata {
    public String adult;
    public BelongsToCollection Belongs_To_Collection;
    public int budget;
    public List<Genre> genres;
    public String homepage;
    public int id;
    public int imdb_id;
    public String original_language;
    public String original_title;
    public String overview;
    public double popularity;
    public String poster_path;
    public List<ProductionCompanies> production_companies;
    public List<ProductionCountries> production_countries;
    public Date release_date;
    public double revenue;
    public double runtime;
    public List<SpokenLanguages> spoken_languages;
    public String status;
    public String tagline;
    public String title;
    public boolean video;
    public double vote_average;
    public int vote_count;

    public MovieMetadata(String adult, BelongsToCollection belongs_To_Collection, int budget,
                         List<Genre> genres, String homepage, int id, int imdb_id,
                         String original_language, String original_title, String overview,
                         double popularity, String poster_path, List<ProductionCompanies> production_companies,
                         List<ProductionCountries> production_countries, Date release_date, double revenue, double runtime,
                         List<SpokenLanguages> spoken_languages, String status, String tagline,
                         String title, boolean video, double vote_average, int vote_count) {
        this.adult = adult;
        Belongs_To_Collection = belongs_To_Collection;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdb_id = imdb_id;
        this.original_language = original_language;
        this.original_title = original_title;
        this.overview = overview;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.production_companies = production_companies;
        this.production_countries = production_countries;
        this.release_date = release_date;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spoken_languages = spoken_languages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public MovieMetadata() {
    }
}
