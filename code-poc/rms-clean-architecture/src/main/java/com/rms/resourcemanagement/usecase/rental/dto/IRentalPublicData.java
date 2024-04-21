package com.rms.resourcemanagement.usecase.rental.dto;

import com.rms.resourcemanagement.usecase.ico.dto.IIcoPublicData;
import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationPublicData;

import java.time.LocalDate;
import java.time.LocalTime;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IRentalPublicData {

    Long id();

    LocalTime hour();

    LocalDate date();

    IBaseLocationPublicData rentalCompany();

    IIcoPublicData customer();

}
