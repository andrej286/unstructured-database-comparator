package com.example.unstructureddatabasecomparator.model.neo4j.MovieKeywords;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Node("Keyword")
public class Keyword {
    @Id
    public String id;
    @JsonAlias("name")
    public String names;

}