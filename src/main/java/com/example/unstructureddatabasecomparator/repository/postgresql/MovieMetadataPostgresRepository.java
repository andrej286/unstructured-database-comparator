package com.example.unstructureddatabasecomparator.repository.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData.MovieMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMetadataPostgresRepository extends JpaRepository<MovieMetadata, Long> {

  @Query("SELECT m.title FROM MovieMetadata m WHERE LOWER(m.title) LIKE %:keyword%")
  List<String> getMovieNamesContainingKeyword(@Param("keyword") String keyword);

  @Query("SELECT DISTINCT pc.name FROM ProductionCompanies pc " +
          "JOIN pc.movieMetadata m " +
          "WHERE LOWER(m.title) LIKE %:keyword%")
  List<String> getProductionCompaniesByMovieTitleContainingKeyword(@Param("keyword") String keyword);

  @Query(nativeQuery=true,
          value = "SELECT AVG(CAST(r.rating AS double precision)) FROM Rating r " +
                  "WHERE r.movie_id IN (SELECT CAST(m.id AS character varying) FROM movie_metadata m WHERE LOWER(m.title) LIKE %:keyword%)")
  Double getAverageRatingForAllTheMoviesWithTitleContainingKeyword(@Param("keyword") String keyword);

  @Query(nativeQuery = true,
          value = "SELECT k.names FROM keyword k " +
                  "JOIN movie_keywords mk ON k.movie_keywords_id = mk.id " +
                  "JOIN movie_metadata m ON mk.id = CAST(m.id AS character varying)" +
                            "WHERE m.id IN (SELECT mm.id FROM movie_metadata mm " +
                            "               JOIN rating r ON r.movie_id = CAST(mm.id AS character varying) " +
                            "               GROUP BY mm.id " +
                            "               ORDER BY AVG(CAST(r.rating AS double precision)) DESC " +
                            "               LIMIT 10)")
  List<String> getKeywordsForMovieWithTop10HighestAverageRating();
}