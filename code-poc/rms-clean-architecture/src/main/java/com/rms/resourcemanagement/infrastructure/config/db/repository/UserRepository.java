package com.rms.resourcemanagement.infrastructure.config.db.repository;

import com.rms.resourcemanagement.infrastructure.config.db.schema.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserSchema, Long> {
  Optional<UserSchema> findByEmail(String email);

  Optional<UserSchema> findByUsername(String username);

  Collection<UserSchema> findAllByEmail(String email);

  Collection<UserSchema> findAllByUsername(String username);
}
