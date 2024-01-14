package com.example.unstructureddatabasecomparator.service.neo4j;

import com.example.unstructureddatabasecomparator.repository.neo4j.MovieKeywordsNeo4JRepository;
import com.example.unstructureddatabasecomparator.repository.neo4j.Neo4JMovieMetadataRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Neo4JService {

  private MovieKeywordsNeo4JRepository movieKeywordsNeo4JRepository;
  private Neo4JMovieMetadataRepository movieMetadataRepository;

  @Async
  public void loadDataset() {
  }

  public Double executeFistQuery() {

    String keyword = "pirate";

    long startTime = System.currentTimeMillis();

    List<String> movieNames = movieMetadataRepository.getMovieNamesContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    movieNames.clear();

    return (double) executionTime / 1000;
  }

  public Double executeSecondQuery() {
    return 3.0;
  }

  public Double executeThirdQuery() {
    return 2.0;
  }

  public Double executeFourthQuery() {
    return 1.0;
  }
}
