package com.example.unstructureddatabasecomparator.repository.postgresql;

import com.example.unstructureddatabasecomparator.model.postgresql.example.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresUserRepository extends JpaRepository<User, Long> {

  User save(User user);
}
