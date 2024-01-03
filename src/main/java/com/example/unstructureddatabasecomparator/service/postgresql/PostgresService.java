package com.example.unstructureddatabasecomparator.service.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.Credits.Credits;
import com.example.unstructureddatabasecomparator.model.postgresql.Link;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords.MovieKeywords;
import com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData.MovieMetadata;
import com.example.unstructureddatabasecomparator.model.postgresql.Rating;
import com.example.unstructureddatabasecomparator.repository.postgresql.*;
import com.example.unstructureddatabasecomparator.util.CSVReaderPostgres;
import com.example.unstructureddatabasecomparator.util.Kaggle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PostgresService {

  private RatingPostgresRepository ratingPostgresRepository;
  private LinkPostgresRepository linkPostgresRepository;
  private MovieKeywordsPostgresRepository movieKeywordsPostgresRepository;
  private MovieMetadataPostgresRepository movieMetadataPostgresRepository;
  private CreditsPostgresRepository creditsPostgresRepository;

  private static int MAX_ROWS = 10000;

  public void loadDataset() {

    Kaggle.downloadDataset();

    ArrayList<Rating> postgresRatings = CSVReaderPostgres.loadRatings(MAX_ROWS);
    ratingPostgresRepository.saveAll(postgresRatings);

    ArrayList<Link> postgresLinks = CSVReaderPostgres.loadLinks(MAX_ROWS);
    linkPostgresRepository.saveAll(postgresLinks);

    ArrayList<MovieKeywords> postgresKeywords = CSVReaderPostgres.loadKeywords(MAX_ROWS);
    movieKeywordsPostgresRepository.saveAll(postgresKeywords);

    ArrayList<MovieMetadata> postgresMovieMetadata = CSVReaderPostgres.loadMovies(MAX_ROWS);
    movieMetadataPostgresRepository.saveAll(postgresMovieMetadata);

    ArrayList<Credits> postgresCredits = CSVReaderPostgres.loadCredits(MAX_ROWS);
    creditsPostgresRepository.saveAll(postgresCredits);
  }

  public Double executeFistQuery() {
    return 1.0;
  }

  public Double executeSecondQuery() {
    return 2.0;
  }

  public Double executeThirdQuery() {
    return 3.0;
  }

  public Double executeFourthQuery() {
    return 4.0;
  }
}
