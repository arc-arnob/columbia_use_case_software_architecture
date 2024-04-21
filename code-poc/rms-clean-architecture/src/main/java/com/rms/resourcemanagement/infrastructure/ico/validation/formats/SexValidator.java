package com.rms.resourcemanagement.infrastructure.ico.validation.formats;

import com.rms.resourcemanagement.entity.ico.model.Sex;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class SexValidator implements ConstraintValidator<com.rms.resourcemanagement.infrastructure.ico.validation.formats.Sex, String> {

  @Override
  public boolean isValid(String sex, ConstraintValidatorContext context) {
    if (sex == null || sex.isBlank()) return true; // We ignore whether the field is null in update requests
    try {
      Sex.valueOf(sex);
    } catch (IllegalArgumentException e) {
      return false;
    }

    return true;
  }
}