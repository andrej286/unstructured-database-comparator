package com.example.unstructureddatabasecomparator.repository.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.MovieMetaData.MovieMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMetadataPostgresRepository extends JpaRepository<MovieMetadata, Long> {

}