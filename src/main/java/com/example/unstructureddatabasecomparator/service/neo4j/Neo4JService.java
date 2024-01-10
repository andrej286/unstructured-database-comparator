package com.example.unstructureddatabasecomparator.service.neo4j;

import com.example.unstructureddatabasecomparator.model.neo4j.MovieKeywords.MovieKeywords;
import com.example.unstructureddatabasecomparator.repository.neo4j.MovieKeywordsNeo4JRepository;
import com.example.unstructureddatabasecomparator.util.CSVReaderNeo4J;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class Neo4JService {

  private MovieKeywordsNeo4JRepository movieKeywordsNeo4JRepository;

  private final int MAX_ROWS = 4000;

  @Async
  public void loadDataset() {
    ArrayList<MovieKeywords> movieKeywords = CSVReaderNeo4J.loadKeywords(MAX_ROWS);
    movieKeywordsNeo4JRepository.saveAll(movieKeywords);
  }

  public Double executeFistQuery() {
    return 4.0;
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
