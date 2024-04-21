package com.rms.resource.management.dto.rental;

import com.rms.resource.management.validation.classlevel.ValidRentalRegistration;
import com.rms.resource.management.validation.formats.rental.RentalDate;
import com.rms.resource.management.validation.formats.rental.RentalHour;
import jakarta.validation.constraints.NotNull;

@ValidRentalRegistration(message = "{ValidRental.rental}")
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
    Long customerId) {
}
