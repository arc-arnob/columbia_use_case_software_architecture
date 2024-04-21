package com.rms.resource.management.dto.rental;

import com.rms.resource.management.domain.Rental;
import com.rms.resource.management.dto.baseLocation.BaseLocationPublicListingData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsCustomes(
    Long id, LocalTime hour,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date, BaseLocationPublicListingData rentalCompany) {
  public RentalDetailsCustomes(Rental rental) {
    this(rental.getId(), rental.getHour(), rental.getDate(),
        new BaseLocationPublicListingData(rental.getRentalCompany()));
  }

}
