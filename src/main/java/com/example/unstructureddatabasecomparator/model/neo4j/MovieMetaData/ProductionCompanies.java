package com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData;

import org.springframework.data.neo4j.core.schema.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("ProductionCompanies")
public class ProductionCompanies {
    @Id
    public int Id;
    public String name;
}
