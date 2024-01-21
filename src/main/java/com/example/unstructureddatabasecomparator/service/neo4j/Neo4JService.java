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

  /**
   * Sends a query to get all the names of the movies containing a given word.
   *
   * @return the time it took to execute the query.
   */
  public Double executeFistQuery() {

    String keyword = "pirate";

    long startTime = System.currentTimeMillis();

    List<String> movieNames = movieMetadataRepository.getMovieNamesContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    movieNames.clear();

    return (double) executionTime / 1000;
  }

  /**
   * Sends a query to get all the production company names that have made
   * a movie with a title of a given word
   *
   * @return the time it took to execute the query.
   */
  public Double executeSecondQuery() {

    String keyword = "batman";

    long startTime = System.currentTimeMillis();

    List<String> productionCompanyNames = movieMetadataRepository.getProductionCompaniesByMovieTitleContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    productionCompanyNames.clear();

    return (double) executionTime / 1000;
  }

  /**
   * Sends a query to get the average of all the ratings for a certain movie name
   *
   * @return the time it took to execute the query.
   */
  public Double executeThirdQuery() {
    String keyword = "batman";

    long startTime = System.currentTimeMillis();

//    Double rating = movieMetadataRepository.getAverageRatingForAllTheMoviesWithTitleContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    return (double) executionTime / 1000;
  }

  /**
   * Sends a query to get the keywords of the top 10 movies with the highest rating.
   *
   * @return the time it took to execute the query.
   */
  public Double executeFourthQuery() {
    return 1.0;
  }
}
