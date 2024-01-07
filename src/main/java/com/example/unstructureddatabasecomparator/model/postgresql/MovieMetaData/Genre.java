package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Genre {

  @Id
  public int Id;
  public String name;

  @ManyToOne
  private MovieMetadata movieMetadata;
}
