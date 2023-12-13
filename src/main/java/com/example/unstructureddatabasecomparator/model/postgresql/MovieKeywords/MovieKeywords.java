package com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MovieKeywords{
    public String id;
    public List<Keyword> keywords;
}
