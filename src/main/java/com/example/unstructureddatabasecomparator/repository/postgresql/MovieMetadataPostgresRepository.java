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
}