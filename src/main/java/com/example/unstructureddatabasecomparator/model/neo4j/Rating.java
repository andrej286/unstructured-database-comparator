package com.example.unstructureddatabasecomparator.model.neo4j;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Rating")
public class Rating {

  @Id
  public String userId;
  public String movieId;
  public String rating;
  public String timestamp;
}