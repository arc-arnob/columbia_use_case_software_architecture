package com.rms.resource.management.service.impl;

import com.rms.resource.management.domain.BaseLocation;
import com.rms.resource.management.dto.baseLocation.BaseLocationUpdateData;
import com.rms.resource.management.dto.baseLocation.BaseLocationRegistrationData;
import com.rms.resource.management.repository.IBaseLocationRepository;
import com.rms.resource.management.repository.IUserRepository;
import com.rms.resource.management.service.spec.IBaseLocationService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = false)
public class BaseLocationService implements IBaseLocationService {

  @Autowired
  private Validator validator;

  @Autowired
  private IBaseLocationRepository repository;

  @Autowired
  private IUserRepository usuarioRepository;

  public BaseLocation save(BaseLocationRegistrationData dados) {
    BaseLocation rentalCompany = new BaseLocation(dados);

    Set<ConstraintViolation<BaseLocation>> violations = validator.validate(rentalCompany);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(rentalCompany);
    return rentalCompany;
  }

  public BaseLocation delete(Long id) {
    BaseLocation rentalCompany = repository.findById(id).orElse(null);

    if (rentalCompany == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return rentalCompany;
  }

  @Override
  public BaseLocation update(Long id, BaseLocationUpdateData dados) {
    BaseLocation rentalCompany = repository.findById(id).orElse(null);

    if (rentalCompany == null) {
      throw new EntityNotFoundException();
    }

    if (dados.email() != null && !dados.email().equals(rentalCompany.getEmail())) {
      int quantidadeEmail = usuarioRepository.findAllByEmail(dados.email()).size();
      if (quantidadeEmail > 0) {
        throw new ConstraintViolationException("Email já cadastrado", Set.of(
            validator.validateProperty(rentalCompany, "email").iterator().next()
        ));
      }
    }

    if (dados.username() != null && !dados.username().equals(rentalCompany.getUsername())) {
      int quantidadeUsername = usuarioRepository.findAllByUsername(dados.username()).size();
      if (quantidadeUsername > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(rentalCompany, "username").iterator().next())
        );
      }
    }

    if (dados.cnpj() != null && !dados.cnpj().equals(rentalCompany.getCnpj())) {
      int quantidadeCpf = repository.findAllByCnpj(dados.cnpj()).size();
      if (quantidadeCpf > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(rentalCompany, "cnpj").iterator().next())
        );
      }
    }

    rentalCompany.atualizar(dados);

    return rentalCompany;
  }

  @Override
  public Page<BaseLocation> findAllByCity(String city, Pageable pageable) {

    return repository.findAllByCity(city, pageable);
  }

  @Override
  public List<String> findAllCities() {
    return repository.findAllCities();
  }

  @Transactional(readOnly = true)
  public BaseLocation findById(Long id) {
    BaseLocation rentalCompany = repository.findById(id).orElse(null);

    if (rentalCompany == null) {
      throw new EntityNotFoundException();
    }

    return rentalCompany;
  }

  @Transactional(readOnly = true)
  public Page<BaseLocation> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
