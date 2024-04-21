package com.rms.resource.management.dto.rental;

import com.rms.resource.management.domain.Rental;
import com.rms.resource.management.dto.customer.CustomerPublicData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsRentalCompany(
    Long id, LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,
    CustomerPublicData customer) {
  public RentalDetailsRentalCompany(Rental rental) {
    this(rental.getId(), rental.getHour(), rental.getDate(), new CustomerPublicData(rental.getCustomer()));
  }

}
