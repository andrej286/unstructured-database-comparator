package com.example.unstructureddatabasecomparator.service;

import com.example.unstructureddatabasecomparator.model.neo4j.example.User;
import com.example.unstructureddatabasecomparator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public Collection<User> getAll() {
    return userRepository.getAllUsers();
  }
}