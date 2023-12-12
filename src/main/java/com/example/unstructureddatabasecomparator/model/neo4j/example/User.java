package com.example.unstructureddatabasecomparator.model.neo4j.example;

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
@Node("User")
public class User {

  @Id
  private Long id;
  private String name;
  private Integer age;

  @Relationship(type = "RATED")
  private List<Movie> movies;

  public List<Movie> getMovies() {
    return movies;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }
}