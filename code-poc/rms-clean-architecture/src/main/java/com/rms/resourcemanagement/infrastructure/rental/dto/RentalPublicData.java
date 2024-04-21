package com.rms.resourcemanagement.infrastructure.rental.dto;

import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.rental.dto.IRentalPublicData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalPublicData(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    BaseLocationPublicData rentalCompany,

    IcoPublicData customer
) implements IRentalPublicData {
        public RentalPublicData(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new BaseLocationPublicData(rental.getRentalCompany()),
                        new IcoPublicData(rental.getCustomer())
                );
        }
}