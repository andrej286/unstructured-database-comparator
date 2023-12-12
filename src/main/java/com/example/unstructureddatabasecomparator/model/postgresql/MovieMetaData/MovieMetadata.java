package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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
}
