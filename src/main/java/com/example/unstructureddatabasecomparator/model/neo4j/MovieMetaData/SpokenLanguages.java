package com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Node("SpokenLanguages")
public class SpokenLanguages {
    @Id
    @GeneratedValue
    public Long Id;
    public String iso_639_1;
    public String name;
}
