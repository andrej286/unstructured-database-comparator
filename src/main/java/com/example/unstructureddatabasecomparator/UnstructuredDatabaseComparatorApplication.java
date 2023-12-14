package com.example.unstructureddatabasecomparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jAuditing
@EnableNeo4jRepositories(basePackages = {"com.example.unstructureddatabasecomparator.repository.neo4j"})
@EnableJpaRepositories(basePackages = "com.example.unstructureddatabasecomparator.repository.postgresql")
public class UnstructuredDatabaseComparatorApplication {

  public static void main(String[] args) {
    SpringApplication.run(UnstructuredDatabaseComparatorApplication.class, args);
  }
}
