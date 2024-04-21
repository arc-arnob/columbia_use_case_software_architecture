package com.rms.resourcemanagement.infrastructure.ico.validation.unique;

import com.rms.resourcemanagement.infrastructure.config.db.repository.IcoRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.CustomerSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueCPFValidator implements ConstraintValidator<UniqueCPF, String> {

  @Autowired
  private IcoRepository repository;

  @Override
  public boolean isValid(String CPF, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<CustomerSchema> customer = repository.findByCpf(CPF);
      return customer.isEmpty();
    }

    return true;
  }
}