package com.rms.resourcemanagement.infrastructure.baselocation.controller;

import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationRegistrationData;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.baselocation.CreateBaseLocationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBaseLocationController {

    private final CreateBaseLocationUseCase createRentalCompanyUseCase;

    public CreateBaseLocationController(CreateBaseLocationUseCase createRentalCompanyUseCase) {
        this.createRentalCompanyUseCase = createRentalCompanyUseCase;
    }

    @PostMapping("/rentalCompanies")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseLocationPublicData createRentalCompany(@Valid @RequestBody BaseLocationRegistrationData dados) {
        return new BaseLocationPublicData(createRentalCompanyUseCase.execute(dados));
    }

}
