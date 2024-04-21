package com.rms.resourcemanagement.infrastructure.rental.dto;

import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.rental.dto.IRentalDetailsCustomer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsCustomer(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    BaseLocationPublicData rentalCompany
) implements IRentalDetailsCustomer {
        public RentalDetailsCustomer(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new BaseLocationPublicData(rental.getRentalCompany())
                );
        }
}