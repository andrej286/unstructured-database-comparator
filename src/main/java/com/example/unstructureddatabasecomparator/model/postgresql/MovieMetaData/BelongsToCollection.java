package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import com.fasterxml.jackson.annotation.JsonAlias;
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
  @JsonAlias({"poster_path"})
  public String posterPath;
  @JsonAlias({"backdrop_path"})
  public String backdropPath;


}
