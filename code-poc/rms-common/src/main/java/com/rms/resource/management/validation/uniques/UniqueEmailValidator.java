package com.rms.resource.management.validation.uniques;

import com.rms.resource.management.domain.User;
import com.rms.resource.management.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

  @Autowired
  private IUserRepository repository;

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    if (repository != null) {
      User user = repository.findByEmail(email);
      return user == null;
    } else {
      // Durante a execução da classe LivrariaMvcApplication
      // não há injeção de dependência
    }
    return true;
  }
}