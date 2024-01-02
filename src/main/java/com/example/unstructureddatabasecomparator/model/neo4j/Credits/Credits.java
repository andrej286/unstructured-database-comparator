package com.example.unstructureddatabasecomparator.model.neo4j.Credits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Credits")
public class Credits {
  @Id
  public String id;

  @Relationship(type = "HAS_CAST", direction = Relationship.Direction.OUTGOING)
  public List<Cast> castList;

  @Relationship(type = "HAS_CREW", direction = Relationship.Direction.OUTGOING)
  public List<Crew> crewList;
}