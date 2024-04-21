package com.rms.resourcemanagement.infrastructure.user.validation.unique;

import com.rms.resourcemanagement.infrastructure.config.db.repository.UserRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.UserSchema;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  @Autowired
  private UserRepository repository;

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    if (repository != null) {
      Optional<UserSchema> usuario = repository.findByEmail(email);
      return usuario.isEmpty();
    }

    return true;
  }
}