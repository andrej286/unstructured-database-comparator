package com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Node("BelongsToCollection")
public class BelongsToCollection {
    @Id
    public int id;
    public String name;
    @JsonAlias("poster_path")
    public String posterPath;
    @JsonAlias("backdrop_path")
    public String backdropPath;
}
