package com.example.unstructureddatabasecomparator.repository.neo4j;

import com.example.unstructureddatabasecomparator.model.neo4j.MovieKeywords.MovieKeywords;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieKeywordsNeo4JRepository extends Neo4jRepository<MovieKeywords, String> {

  @Query("MATCH (n:MovieKeyword) RETURN n")
  List<MovieKeywords> getAllKeywords();
}
