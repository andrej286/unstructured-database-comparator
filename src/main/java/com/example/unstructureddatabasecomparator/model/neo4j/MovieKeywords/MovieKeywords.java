package com.example.unstructureddatabasecomparator.model.neo4j.MovieKeywords;

import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Node("MovieKeywords")
public class MovieKeywords{
    @Id
    public String id;

    @Relationship(type = "HAS_KEYWORD", direction = Relationship.Direction.OUTGOING)
    public List<Keyword> keywords;
}
