package com.rms.resourcemanagement.infrastructure.config.db.repository;

import com.rms.resourcemanagement.infrastructure.config.db.schema.CustomerSchema;
import com.rms.resourcemanagement.infrastructure.config.db.schema.RentalSchema;
import com.rms.resourcemanagement.infrastructure.config.db.schema.BaseLocationSchema;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalSchema, Long> {
  List<RentalSchema> findAllByRentalCompany(@NotNull(message = "{NotNull.rental.rentalCompany}") BaseLocationSchema rentalCompany);

  List<RentalSchema> findAllByCustomer(@NotNull CustomerSchema customer);
}
