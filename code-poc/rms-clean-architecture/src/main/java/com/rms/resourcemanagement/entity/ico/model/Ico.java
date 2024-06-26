package com.rms.resourcemanagement.entity.ico.model;

import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.user.model.User;

import java.time.LocalDate;
import java.util.List;

public class Ico extends User {

  private String cpf;
  private String phoneNumber;
  private Sex sex;
  private LocalDate birthdate;
  private List<Rental> rentals;

  public Ico(String username, String password, String name, String email, String cpf, String phoneNumber, Sex sex, LocalDate birthdate) {
    super(username, password, name, email);
    this.cpf = cpf;
    this.phoneNumber = phoneNumber;
    this.sex = sex;
    this.birthdate = birthdate;
  }

  public Ico() {
    this.role = "ROLE_CUSTOMER";
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

  public List<Rental> getRentals() {
    return rentals;
  }

  public void setRentals(List<Rental> rentals) {
    this.rentals = rentals;
  }

}
