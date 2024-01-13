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
