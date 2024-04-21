package com.rms.resourcemanagement.entity.baselocation.model;

import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.user.model.User;

import java.util.List;

public class BaseLocation extends User {

  private String cnpj;
  private String city;
  private List<Rental> rentals;

  public BaseLocation() {
    this.role = "ROLE_RENTALCOMPANY";
  }

  public BaseLocation(String username, String password, String name, String email, String cnpj, String city) {
    super(username, password, name, email);
    this.city = city;
    this.cnpj = cnpj;
    this.role = "ROLE_RENTALCOMPANY";

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

  public List<Rental> getRentals() {
    return rentals;
  }

  public void setRentals(List<Rental> rentals) {
    this.rentals = rentals;
  }
}
