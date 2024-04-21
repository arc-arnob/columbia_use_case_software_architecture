package com.rms.resourcemanagement.infrastructure.rental.dto;

import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.usecase.rental.dto.IRentalDetailsRentalCompany;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public record RentalDetailsRentalCompany(
    Long id,

    @JsonFormat(pattern = "HH:00")
    LocalTime hour,

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date,

    IcoPublicData customer
) implements IRentalDetailsRentalCompany {
        public RentalDetailsRentalCompany(Rental rental) {
                this(
                        rental.getId(),
                        rental.getHour(),
                        rental.getDate(),
                        new IcoPublicData(rental.getCustomer())
                );
        }
}