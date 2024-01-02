package com.example.unstructureddatabasecomparator.model.neo4j;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Link")
public class Link {

  @Id
  public Long id;
  public String movieId;
  public String imdbId;
  public String tmdbId;
}
