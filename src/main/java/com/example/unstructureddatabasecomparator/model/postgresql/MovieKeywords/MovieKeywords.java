package com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(fetch = FetchType.EAGER)
    public List<Keyword> keywords;
}
