package com.rms.resource.management.domain;

import com.rms.resource.management.dto.baseLocation.BaseLocationUpdateData;
import com.rms.resource.management.dto.baseLocation.BaseLocationRegistrationData;
import com.rms.resource.management.validation.formats.baseLocation.CNPJ;
import com.rms.resource.management.validation.uniques.UniqueCNPJ;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Locadora")
public class BaseLocation extends User {

  @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
  @NotBlank
  @CNPJ(message = "{Size.locadora.CNPJ}")
  @Column(unique = true)
  private String cnpj;

  @NotBlank
  @Column(length = 50)
  private String city;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "rentalCompany")
  private List<Rental> locacoes;

  public BaseLocation() {
    this.role = "ROLE_LOCADORA";
  }

  public BaseLocation(BaseLocationRegistrationData dados) {
    this.setUsername(dados.username());
    this.setPassword(dados.password());
    this.setName(dados.name());
    this.setEmail(dados.email());
    this.cnpj = dados.cnpj();
    this.city = dados.city();
    this.role = "ROLE_LOCADORA";
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<Rental> getLocacoes() {
    return locacoes;
  }

  public void atualizar(BaseLocationUpdateData dados) {
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

    if (dados.cnpj() != null && !dados.cnpj().isBlank()) {
      this.cnpj = dados.cnpj();
    }

    if (dados.city() != null && !dados.city().isBlank()) {
      this.city = dados.city();
    }
  }
}
