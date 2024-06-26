package com.rms.resource.management.service.impl;

import com.rms.resource.management.domain.Admin;
import com.rms.resource.management.dto.admin.AdminUpdateData;
import com.rms.resource.management.dto.admin.AdminRegistrationData;
import com.rms.resource.management.repository.IAdminRepository;
import com.rms.resource.management.repository.IUserRepository;
import com.rms.resource.management.service.spec.IAdminService;
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
import java.util.Set;

@Service
@Transactional(readOnly = false)
public class AdminService implements IAdminService {

  @Autowired
  private Validator validator;


  @Autowired
  private IAdminRepository repository;

  @Autowired
  private IUserRepository usuarioRepository;

  public Admin save(AdminRegistrationData dados) {
    Admin admin = new Admin(dados);

    Set<ConstraintViolation<Admin>> violations = validator.validate(admin);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    repository.save(admin);
    return admin;
  }

  public Admin delete(Long id) {
    Admin admin = repository.findById(id).orElse(null);

    if (admin == null) {
      throw new EntityNotFoundException();
    }

    repository.deleteById(id);
    return admin;
  }

  @Override
  public Admin update(Long id, AdminUpdateData dados) {
    Admin admin = repository.findById(id).orElse(null);

    if (admin == null) {
      throw new EntityNotFoundException();
    }

    if (dados.email() != null && !dados.email().equals(admin.getEmail())) {
      int quantidadeEmail = usuarioRepository.findAllByEmail(dados.email()).size();
      if (quantidadeEmail > 0) {
        throw new ConstraintViolationException("Email já cadastrado", Set.of(
            validator.validateProperty(admin, "email").iterator().next()
        ));
      }
    }

    if (dados.username() != null && !dados.username().equals(admin.getUsername())) {
      int quantidadeUsername = usuarioRepository.findAllByUsername(dados.username()).size();
      if (quantidadeUsername > 0) {
        throw new ConstraintViolationException(
            Collections.singleton(validator.validateProperty(admin, "username").iterator().next())
        );
      }
    }

    admin.atualizar(dados);


    return admin;
  }

  @Transactional(readOnly = true)
  public Admin findById(Long id) {
    Admin admin = repository.findById(id).orElse(null);

    if (admin == null) {
      throw new EntityNotFoundException();
    }

    return admin;
  }

  @Transactional(readOnly = true)
  public Page<Admin> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }
}
