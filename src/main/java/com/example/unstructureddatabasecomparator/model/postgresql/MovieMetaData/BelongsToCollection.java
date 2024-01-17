package com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BelongsToCollection {
  @Id
  public int id;
  @Column(length = 500)
  public String name;
  @Column(length = 500)
  @JsonAlias({"poster_path"})
  public String posterPath;
  @Column(length = 500)
  @JsonAlias({"backdrop_path"})
  public String backdropPath;

  @OneToMany(mappedBy = "belongsToCollection", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  public List<MovieMetadata> movieMetadata;
}
