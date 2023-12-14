package com.example.unstructureddatabasecomparator.service.neo4j;

import com.example.unstructureddatabasecomparator.model.neo4j.example.User;
import com.example.unstructureddatabasecomparator.repository.neo4j.Neo4JUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Neo4JUserService {

  @Autowired
  Neo4JUserRepository userRepository;

  public Collection<User> getAll() {
    return userRepository.getAllUsers();
  }
}