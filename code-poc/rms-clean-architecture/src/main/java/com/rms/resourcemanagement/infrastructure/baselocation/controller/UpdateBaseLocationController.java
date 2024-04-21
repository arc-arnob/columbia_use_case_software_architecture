package com.rms.resourcemanagement.infrastructure.baselocation.controller;

import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationUpdateData;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.baselocation.UpdateBaseLocationUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateBaseLocationController {

    private final UpdateBaseLocationUseCase updateRentalCompanyUseCase;

    public UpdateBaseLocationController(UpdateBaseLocationUseCase updateRentalCompanyUseCase) {
        this.updateRentalCompanyUseCase = updateRentalCompanyUseCase;
    }

    @PutMapping("/rentalCompanies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseLocationPublicData updateRentalCompany(@PathVariable Long id, @Valid @RequestBody BaseLocationUpdateData dados) throws BaseLocationNotFoundException {
        return new BaseLocationPublicData(updateRentalCompanyUseCase.execute(id, dados));
    }

}
