package com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Keyword {
    @Id
    public String id;
    @JsonAlias("name")
    public String names;

    @ManyToOne
    @JoinColumn(name = "movie_keywords_id")
    public MovieKeywords movieKeywords;

    public void setMovieKeywords(MovieKeywords movieKeywords) {
        this.movieKeywords = movieKeywords;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id='" + id + '\'' +
                ", names='" + names + '\'' +
                ", movieKeywords.id=" + (movieKeywords == null ? "null" : movieKeywords.getId()) +
                '}';
    }
}