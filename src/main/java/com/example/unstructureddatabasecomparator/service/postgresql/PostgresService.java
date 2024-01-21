package com.example.unstructureddatabasecomparator.service.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.Credits.Credits;
import com.example.unstructureddatabasecomparator.model.postgresql.Link;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords.MovieKeywords;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData.MovieMetadata;
import com.example.unstructureddatabasecomparator.model.postgresql.Rating;
import com.example.unstructureddatabasecomparator.repository.postgresql.*;
import com.example.unstructureddatabasecomparator.util.CSVReaderPostgres;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostgresService {

  private RatingPostgresRepository ratingPostgresRepository;
  private LinkPostgresRepository linkPostgresRepository;
  private MovieKeywordsPostgresRepository movieKeywordsPostgresRepository;
  private MovieMetadataPostgresRepository movieMetadataPostgresRepository;
  private CreditsPostgresRepository creditsPostgresRepository;

  @Async
  public void loadDataset() {

    ArrayList<Link> links = CSVReaderPostgres.loadLinks();
    linkPostgresRepository.saveAll(links);
    links.clear();

    ArrayList<Rating> ratings = CSVReaderPostgres.loadRatings();
    ratingPostgresRepository.saveAll(ratings);
    ratings.clear();

    ArrayList<Credits> credits = CSVReaderPostgres.loadCredits();
    creditsPostgresRepository.saveAll(credits);
    credits.clear();

    ArrayList<MovieMetadata> movieMetadata = CSVReaderPostgres.loadMovies();
    movieMetadataPostgresRepository.saveAll(movieMetadata);
    movieMetadata.clear();

    ArrayList<MovieKeywords> movieKeywords = CSVReaderPostgres.loadKeywords();
    movieKeywordsPostgresRepository.saveAll(movieKeywords);
    movieKeywords.clear();
  }

  /**
   * Sends a query to get all the names of the movies containing a given word.
   *
   * @return the time it took to execute the query.
   */
  public Double executeFistQuery() {

    String keyword = "pirate";

    long startTime = System.currentTimeMillis();

    List<String> movieNames = movieMetadataPostgresRepository.getMovieNamesContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    movieNames.clear();

    return (double) executionTime;
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

    List<String> productionCompanyNames = movieMetadataPostgresRepository.getProductionCompaniesByMovieTitleContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    productionCompanyNames.clear();

    return (double) executionTime;
  }

  /**
   * Sends a query to get the average of all the ratings for a certain movie name
   *
   * @return the time it took to execute the query.
   */
  public Double executeThirdQuery() {

    String keyword = "batman";

    long startTime = System.currentTimeMillis();

    Double rating = movieMetadataPostgresRepository.getAverageRatingForAllTheMoviesWithTitleContainingKeyword(keyword);

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    return (double) executionTime;
  }

  /**
   * Sends a query to get the keywords of the top 10 movies with the highest rating.
   *
   * @return the time it took to execute the query.
   */
  public Double executeFourthQuery() {

    long startTime = System.currentTimeMillis();

    List<String> keywords = movieMetadataPostgresRepository.getKeywordsForMovieWithTop10HighestAverageRating();

    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;

    keywords.clear();

    return (double) executionTime;
  }
}
