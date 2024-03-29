package com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("MovieMetadata")
public class MovieMetadata {

    @Id
    private String id;
    public String adult;
    @Relationship(type = "BELONGS_TO_COLLECTION", direction = Relationship.Direction.INCOMING)
    public BelongsToCollection belongs_to_collection;
    public String budget;
    @Relationship(type = "HAS_GENRE", direction = Relationship.Direction.OUTGOING)
    public List<Genre> genres;
    public String homepage;
    public String imdb_id;
    public String original_language;
    public String original_title;
    public String overview;
    public String popularity;
    public String poster_path;
    @Relationship(type = "HAS_PRODUCTION_COMPANY", direction = Relationship.Direction.OUTGOING)
    public List<ProductionCompanies> production_companies;
    @Relationship(type = "HAS_PRODUCTION_COUNTRY", direction = Relationship.Direction.OUTGOING)
    public List<ProductionCountries> production_countries;
    public String release_date;
    public String revenue;
    public String runtime;
    @Relationship(type = "HAS_SPOKEN_LANGUAGE", direction = Relationship.Direction.OUTGOING)
    public List<SpokenLanguages> spoken_languages;
    public String status;
    public String tagline;
    public String title;
    public String video;
    public String vote_average;
    public String vote_count;
}
