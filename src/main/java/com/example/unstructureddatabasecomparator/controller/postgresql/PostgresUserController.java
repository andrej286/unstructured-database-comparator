package com.example.unstructureddatabasecomparator.controller.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.example.User;
import com.example.unstructureddatabasecomparator.service.postgresql.PostgresUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/postgresql/user")
public class PostgresUserController {

  @Autowired
  PostgresUserService userService;

  @GetMapping
  public Collection<User> getAll() {
    return userService.getAll();
  }

  @GetMapping("/add")
  public void createUser() {
    userService.saveUser(new User(1L, "test", 11, List.of()));
  }
}