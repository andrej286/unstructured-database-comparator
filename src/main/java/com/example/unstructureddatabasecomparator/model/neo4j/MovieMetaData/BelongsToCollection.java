package com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData;

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
    public String posterPath;
    public String backdropPath;
}
