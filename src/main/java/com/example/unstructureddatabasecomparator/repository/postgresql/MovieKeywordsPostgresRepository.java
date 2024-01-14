package com.example.unstructureddatabasecomparator.repository.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.MovieKeywords.MovieKeywords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieKeywordsPostgresRepository extends JpaRepository<MovieKeywords, Long> {

  @Query(value = "SELECT * FROM movie_keywords", nativeQuery = true)
  List<MovieKeywords> getAllKeywords();
}