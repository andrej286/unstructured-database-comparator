package com.example.unstructureddatabasecomparator.repository.neo4j;

import com.example.unstructureddatabasecomparator.model.neo4j.MovieKeywords.MovieKeywords;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieKeywordsNeo4JRepository extends Neo4jRepository<MovieKeywords, String> {
}
