package com.example.unstructureddatabasecomparator.model.MovieMetaData;

public class BelongsToCollection {
    public int id;
    public String name;
    public String posterPath;
    public String backdropPath;

    public BelongsToCollection() {
    }

    public BelongsToCollection(int id, String name, String posterPath, String backdropPath) {
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }
}
