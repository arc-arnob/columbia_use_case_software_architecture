package com.rms.resourcemanagement.infrastructure.baselocation.validation.unique;

import com.rms.resourcemanagement.infrastructure.config.db.repository.RentalCompanyRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.BaseLocationSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

  @Autowired
  private RentalCompanyRepository repository;

  @Override
  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<BaseLocationSchema> rentalCompany = repository.findByCnpj(CNPJ);
      return rentalCompany.isEmpty();
    }

    return true;
  }
}