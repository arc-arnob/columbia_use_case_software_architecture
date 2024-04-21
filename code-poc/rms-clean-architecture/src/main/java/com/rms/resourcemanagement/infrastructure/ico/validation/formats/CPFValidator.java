package com.rms.resourcemanagement.infrastructure.ico.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CPFValidator implements ConstraintValidator<CPF, String> {

  @Override
  public boolean isValid(String cpf, ConstraintValidatorContext context) {
    if (cpf == null || cpf.isBlank())
      return true;
    return true;
  }
}