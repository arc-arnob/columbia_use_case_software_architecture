package com.rms.resourcemanagement.infrastructure.baselocation.controller;

import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.baselocation.GetBaseLocationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBaseLocationController {

    private final GetBaseLocationUseCase getRentalCompanyUseCase;

    public GetBaseLocationController(GetBaseLocationUseCase getRentalCompanyUseCase) {
        this.getRentalCompanyUseCase = getRentalCompanyUseCase;
    }

    @GetMapping("/rentalCompanies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseLocationPublicData getRentalCompany(@PathVariable Long id) throws BaseLocationNotFoundException {
        BaseLocation rentalCompany = getRentalCompanyUseCase.execute(id);

        return new BaseLocationPublicData(rentalCompany);
    }

}
