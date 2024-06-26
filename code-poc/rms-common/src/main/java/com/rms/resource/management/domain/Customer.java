package com.rms.resource.management.domain;

import com.rms.resource.management.dto.customer.CUstomerUpdateData;
import com.rms.resource.management.dto.customer.CustomerRegistrationData;
import com.rms.resource.management.validation.formats.customer.BirthDate;
import com.rms.resource.management.validation.formats.customer.CPF;
import com.rms.resource.management.validation.formats.customer.PhoneNumber;
import com.rms.resource.management.validation.uniques.UniqueCPF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer extends User {

  @UniqueCPF(message = "{Unique.customer.CPF}")
  @NotBlank
  @CPF(message = "{Size.customer.CPF}")
  @Column(unique = true)
  private String cpf;

  @NotBlank
  @PhoneNumber(message = "{Size.customer.phone}")
  private String phoneNumber;

  @NotNull
  @Enumerated(EnumType.STRING)
  private Sex sex;

  @BirthDate(message = "{BirthDate.customer}")
  @Column(columnDefinition = "Date")
  private LocalDate birthdate;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
  private List<Rental> locacoes;

  public Customer() {
    this.role = "ROLE_CUSTOMER";
  }

  public Customer(CustomerRegistrationData dados) {
    super(dados.username(), dados.password(), dados.name(), dados.email());
    this.role = "ROLE_CUSTOMER";
    this.cpf = dados.cpf();
    this.phoneNumber = dados.phoneNumber();
    this.sex = Sex.valueOf(dados.sex());
    this.birthdate = LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public List<Rental> getLocacoes() {
    return locacoes;
  }

  public void setLocacoes(List<Rental> locacoes) {
    this.locacoes = locacoes;
  }

  public void atualizar(CUstomerUpdateData dados) {
    if (dados.username() != null && !dados.username().isBlank()) {
      this.setUsername(dados.username());
    }

    if (dados.password() != null && !dados.password().isBlank()) {
      this.setPassword(dados.password());
    }

    if (dados.name() != null && !dados.name().isBlank()) {
      this.setName(dados.name());
    }

    if (dados.email() != null && !dados.email().isBlank()) {
      this.setEmail(dados.email());
    }

    if (dados.cpf() != null && !dados.cpf().isBlank()) {
      this.setCpf(dados.cpf());
    }

    if (dados.phoneNumber() != null && !dados.phoneNumber().isBlank()) {
      this.setPhoneNumber(dados.phoneNumber());
    }

    if (dados.sex() != null && !dados.sex().isBlank()) {
      this.setSex(Sex.valueOf(dados.sex()));
    }

    if (dados.birthdate() != null && !dados.birthdate().isBlank()) {
      this.setBirthdate(LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }


  }
}
