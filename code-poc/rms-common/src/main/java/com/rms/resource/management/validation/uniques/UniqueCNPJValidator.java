package com.rms.resource.management.validation.uniques;

import com.rms.resource.management.domain.BaseLocation;
import com.rms.resource.management.repository.IBaseLocationRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UniqueCNPJValidator implements ConstraintValidator<UniqueCNPJ, String> {

  @Autowired
  private IBaseLocationRepository repository;

  @Override
  public boolean isValid(String CNPJ, ConstraintValidatorContext context) {
    if (repository != null) {
      BaseLocation rentalCompany = repository.findByCnpj(CNPJ);
      return rentalCompany == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
      return true;
    }

  }
}