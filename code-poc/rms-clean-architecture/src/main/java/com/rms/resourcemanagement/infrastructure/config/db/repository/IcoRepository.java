package com.rms.resourcemanagement.infrastructure.config.db.repository;

import com.rms.resourcemanagement.infrastructure.config.db.schema.CustomerSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IcoRepository extends JpaRepository<CustomerSchema, Long> {
  Optional<CustomerSchema> findByCpf(String cpf);
}
