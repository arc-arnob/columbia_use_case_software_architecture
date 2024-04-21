package com.rms.resourcemanagement.entity.rental.model;

import com.rms.resourcemanagement.entity.AbstractEntity;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

import java.time.LocalDate;
import java.time.LocalTime;

public class Rental extends AbstractEntity<Long> {
  private LocalTime hour;
  private LocalDate date;
  private BaseLocation rentalCompany;
  private Ico customer;

  public Rental(LocalTime hour, LocalDate date, BaseLocation rentalCompany, Ico customer) {
    this.customer = customer;
    this.hour = hour;
    this.date = date;
    this.rentalCompany = rentalCompany;
  }

    public LocalTime getHour() {
    return hour;
  }

  public void setHour(LocalTime hour) {
    this.hour = hour;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public BaseLocation getRentalCompany() {
    return rentalCompany;
  }

  public void setRentalCompany(BaseLocation rentalCompany) {
    this.rentalCompany = rentalCompany;
  }

  public Ico getCustomer() {
    return customer;
  }

  public void setCustomer(Ico customer) {
    this.customer = customer;
  }
}
