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
    public String id;

    @OneToMany(mappedBy = "movieKeywords", cascade = CascadeType.ALL)
    public List<Keyword> keywords;
}
