package com.rms.resource.management.dto.rental;

import com.rms.resource.management.domain.Rental;
import com.rms.resource.management.dto.customer.CustomerPublicData;
import com.rms.resource.management.dto.baseLocation.BaseLocationPublicListingData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetails(
    Long id,
    @JsonFormat(pattern = "HH:00")
    LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date, BaseLocationPublicListingData rentalCompany,
    CustomerPublicData customer) {
  public RentalDetails(Rental rental) {
    this(rental.getId(), rental.getHour(), rental.getDate(),
        new BaseLocationPublicListingData(rental.getRentalCompany()), new CustomerPublicData(rental.getCustomer()));
  }

}
