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

  public void loadDataset() {

    ArrayList<MovieMetadata> movieMetadata = CSVReaderPostgres.loadMovies();
    movieMetadataPostgresRepository.saveAll(movieMetadata);
  }

  // NOTE: ratings and link we import into the database manually
  private void loadCredits() {
    // NOTE: Most of these fail, but the array still returns some and we save these
    ArrayList<Credits> postgresCredits = CSVReaderPostgres.loadCredits();
    creditsPostgresRepository.saveAll(postgresCredits);
  }

  private void loadMovieKeywords() {
    ArrayList<MovieKeywords> movieKeywords = CSVReaderPostgres.loadKeywords();
    movieKeywordsPostgresRepository.saveAll(movieKeywords);
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
