package com.example.unstructureddatabasecomparator.repository.neo4j;


import com.example.unstructureddatabasecomparator.model.neo4j.example.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.Collection;

public interface Neo4JUserRepository extends Neo4jRepository<User, Long> {

  @Query("MATCH (u:User)<-[r:RATED]-(m:Movie) RETURN u,r,m")
  Collection<User> getAllUsers();
}