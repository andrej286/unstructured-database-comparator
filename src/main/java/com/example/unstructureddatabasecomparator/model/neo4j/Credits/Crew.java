package com.example.unstructureddatabasecomparator.model.neo4j.Credits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Crew")
public class Crew {

  @Id
  public String id;
  public String credit_id; //foreign key for Credit
  public String department;
  public String gender;
  public String job;
  public String name;
  public String profile_path;
}
