package com.rms.resourcemanagement.infrastructure.rental.dto;

import com.rms.resourcemanagement.infrastructure.rental.validation.classlevel.ValidRentalRegistrationData;
import com.rms.resourcemanagement.infrastructure.rental.validation.formats.RentalDate;
import com.rms.resourcemanagement.infrastructure.rental.validation.formats.RentalHour;

import com.rms.resourcemanagement.usecase.rental.dto.IRentalRegistrationData;
import jakarta.validation.constraints.NotNull;

@ValidRentalRegistrationData(message = "{ValidRental.rental}")
public record RentalRegistrationData(
    @RentalHour(message = "{Hour.rental}")
    @NotNull
    String hour,

    @RentalDate(message = "{Date.rental}")
    @NotNull
    String date,

    @NotNull
    Long rentalCompanyId,

    @NotNull
    Long customerId
    ) implements IRentalRegistrationData { }