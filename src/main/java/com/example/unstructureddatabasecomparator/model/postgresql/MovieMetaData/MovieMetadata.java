package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import jakarta.persistence.*;
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

  @Column(length = 500)
  public String adult;
  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "belongs_to_collection_id")
  public BelongsToCollection belongsToCollection;
  public int budget;
  @OneToMany(mappedBy = "movieMetadata", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  public List<Genre> genres;
  @Column(length = 500)
  public String homepage;
  @Id
  public int id;
  public int imdb_id;
  @Column(length = 500)
  public String original_language;
  @Column(length = 500)
  public String original_title;
  @Column(length = 2000)
  public String overview;
  public double popularity;
  @Column(length = 500)
  public String poster_path;
  @OneToMany(mappedBy = "movieMetadata", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  public List<ProductionCompanies> production_companies;
  @OneToMany(mappedBy = "movieMetadata", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  public List<ProductionCountries> production_countries;
  public Date release_date;
  public double revenue;
  public double runtime;
  @OneToMany(mappedBy = "movieMetadata", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  public List<SpokenLanguages> spoken_languages;
  @Column(length = 500)
  public String status;
  @Column(length = 500)
  public String tagline;
  @Column(length = 500)
  public String title;
  public boolean video;
  public double vote_average;
  public int vote_count;
}
