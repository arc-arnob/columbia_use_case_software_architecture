package com.rms.resource.management.repository;

import com.rms.resource.management.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IUserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);

  User findByUsername(String username);

  Collection<User> findAllByEmail(String email);

  Collection<User> findAllByUsername(String username);
}
