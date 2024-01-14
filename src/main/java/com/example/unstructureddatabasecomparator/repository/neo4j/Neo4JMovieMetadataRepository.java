package com.example.unstructureddatabasecomparator.repository.neo4j;

import com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData.MovieMetadata;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface Neo4JMovieMetadataRepository extends Neo4jRepository<MovieMetadata, String> {


  @Query("MATCH (n:MovieMetadata) RETURN n")
  List<MovieMetadata> getAllMovieMetadata();
}
