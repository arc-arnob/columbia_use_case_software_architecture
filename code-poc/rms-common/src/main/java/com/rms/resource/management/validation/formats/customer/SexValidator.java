package com.rms.resource.management.validation.formats.customer;

import com.rms.resource.management.domain.Sex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SexValidator implements ConstraintValidator<com.rms.resource.management.validation.formats.customer.Sex, String> {

  @Override
  public boolean isValid(String sex, ConstraintValidatorContext context) {
    if (sex == null || sex.isBlank()) return true; // Ignoramos se o campo é nulo em requisições de atualização

    try {
      Sex.valueOf(sex);
    } catch (IllegalArgumentException e) {
      return false;
    }

    return true;
  }
}