package com.example.unstructureddatabasecomparator.model.postgresql;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MovieKeywords{

    public String id;
    public List<Keyword> keywords;

    public static class Keyword {
        public String id;
        public String names;

        public Keyword(String id, String names) {
            this.id = id;
            this.names = names;
        }
    }
}
