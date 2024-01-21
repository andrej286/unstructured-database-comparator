package com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MovieKeywords{
    @Id
    public String id;//this is the same id as MovieMetadata id parameter

    @OneToMany(mappedBy = "movieKeywords", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Keyword> keywords;

    @Override
    public String toString() {
        return "MovieKeywords{" +
                "id='" + id + '\'' +
                ", keywords=" + (keywords == null ? "null" : keywords.size()) +
                '}';
    }
}
