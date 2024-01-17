package com.example.unstructureddatabasecomparator.repository.neo4j;

import com.example.unstructureddatabasecomparator.model.neo4j.MovieMetaData.MovieMetadata;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface Neo4JMovieMetadataRepository extends Neo4jRepository<MovieMetadata, String> {

  @Query("MATCH (n:MovieMetadata) WHERE toLower(n.title) CONTAINS $keyword RETURN n.title")
  List<String> getMovieNamesContainingKeyword(String keyword);

  @Query("MATCH (m:MovieMetadata)-[:HAS_PRODUCTION_COMPANY]->(pc:ProductionCompanies) " +
          "WHERE toLower(m.title) CONTAINS toLower($keyword) " +
          "RETURN DISTINCT pc.name")
  List<String> getProductionCompaniesByMovieTitleContainingKeyword( String keyword);
}
