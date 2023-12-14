package com.example.unstructureddatabasecomparator.controller.neo4J;

import com.example.unstructureddatabasecomparator.model.neo4j.example.User;
import com.example.unstructureddatabasecomparator.service.neo4j.Neo4JUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/user")
public class Neo4JUserController {

  @Autowired
  Neo4JUserService userService;

  @GetMapping
  public Collection<User> getAll() {
    return userService.getAll();
  }
}