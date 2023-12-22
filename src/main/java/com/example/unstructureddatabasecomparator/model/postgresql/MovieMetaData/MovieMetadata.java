package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MovieMetadata {

  public String adult;
  @ManyToOne
  public BelongsToCollection Belongs_To_Collection;
  public int budget;
  @OneToMany
  public List<Genre> genres;
  public String homepage;
  @Id
  public int id;
  public int imdb_id;
  public String original_language;
  public String original_title;
  public String overview;
  public double popularity;
  public String poster_path;
  @OneToMany
  public List<ProductionCompanies> production_companies;
  @OneToMany
  public List<ProductionCountries> production_countries;
  public Date release_date;
  public double revenue;
  public double runtime;
  @OneToMany
  public List<SpokenLanguages> spoken_languages;
  public String status;
  public String tagline;
  public String title;
  public boolean video;
  public double vote_average;
  public int vote_count;
}
