package com.rms.resource.management.domain;

import com.rms.resource.management.dto.rental.RentalRegistrationData;
import com.rms.resource.management.validation.classlevel.ValidRental;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@ValidRental(message = "{ValidRental.rental}")
@Entity
@Table(name = "Rental",
    uniqueConstraints = @UniqueConstraint(columnNames = {"hour", "date", "customer_id"})
)
public class Rental extends AbstractEntity<Long> {
  @NotNull
  @Column(nullable = false, columnDefinition = "Time", name = "hour")
  private LocalTime hour;

  @NotNull
  @Column(nullable = false, columnDefinition = "Date", name = "date")
  private LocalDate date;

  @NotNull(message = "{NotNull.rental.locadora}")
  @ManyToOne
  @JoinColumn(name = "rentalCompany_id")
  private BaseLocation rentalCompany;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public Rental(RentalRegistrationData rental, BaseLocation rentalCompany, Customer customer) {
    this.hour = LocalTime.parse(rental.hour(), DateTimeFormatter.ofPattern("HH:00"));
    this.date = LocalDate.parse(rental.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    this.rentalCompany = rentalCompany;
    this.customer = customer;
  }

  public Rental() {
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
