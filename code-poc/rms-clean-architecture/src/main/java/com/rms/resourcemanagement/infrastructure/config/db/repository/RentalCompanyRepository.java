package com.rms.resourcemanagement.infrastructure.config.db.repository;

import com.rms.resourcemanagement.infrastructure.config.db.schema.BaseLocationSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RentalCompanyRepository extends JpaRepository<BaseLocationSchema, Long> {
  Optional<BaseLocationSchema> findByCnpj(String cpf);

  @Query("SELECT DISTINCT l.city FROM BaseLocationSchema l")
  List<String> findAllCities();

  List<BaseLocationSchema> findAllByCity(String city);

  Optional<BaseLocationSchema> findByName(String name);
}
