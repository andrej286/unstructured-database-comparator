package com.example.unstructureddatabasecomparator.service.postgresql;


import com.example.unstructureddatabasecomparator.model.postgresql.example.User;
import com.example.unstructureddatabasecomparator.repository.postgresql.PostgresUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PostgresUserService {

  @Autowired
  PostgresUserRepository userRepository;

  public Collection<User> getAll() {
    return userRepository.findAll();
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }
}
