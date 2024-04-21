package com.rms.resourcemanagement.usecase.rental.dto;

import com.rms.resourcemanagement.usecase.ico.dto.IIcoPublicData;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalDetailsRentalCompany {

    Long id();

    LocalTime hour();

    LocalDate date();

    IIcoPublicData customer();

}
