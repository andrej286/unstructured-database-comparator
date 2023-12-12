package com.example.unstructureddatabasecomparator.model.neo4j;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Rating {

  public String userId;
  public String movieId;
  public String rating;
  public String timestamp;
}