package com.example.unstructureddatabasecomparator.model.neo4j.Credits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Cast")
public class Cast {

  @Id
  public String cast_id;
  public String character;
  public String credit_id; //foreign key for Credit
  public String gender;
  public String id;
  public String name;

  public String order;
  public String profile_path;
}
