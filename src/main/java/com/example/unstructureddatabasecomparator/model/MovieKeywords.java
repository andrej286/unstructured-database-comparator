package com.example.unstructureddatabasecomparator.model;

import java.util.ArrayList;
import java.util.List;

public class MovieKeywords{
    public String id;
    public List<Keyword> keywords;

    public MovieKeywords() {
        this.keywords = new ArrayList<>();
    }

    public MovieKeywords(String id, List<Keyword> keywords) {
        this.id = id;
        this.keywords = keywords;
    }

    public static class Keyword {
        public String id;
        public String names;

        public Keyword(String id, String names) {
            this.id = id;
            this.names = names;
        }
    }
}
