package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BelongsToCollection {
  @Id
  public int id;
  public String name;
  public String posterPath;
  public String backdropPath;


}
