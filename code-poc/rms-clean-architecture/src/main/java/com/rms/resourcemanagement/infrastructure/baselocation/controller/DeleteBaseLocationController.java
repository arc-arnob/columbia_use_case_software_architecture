package com.rms.resourcemanagement.infrastructure.baselocation.controller;

import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.baselocation.DeleteBaseLocationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteBaseLocationController {

    private final DeleteBaseLocationUseCase deleteRentalCompanyUseCase;

    public DeleteBaseLocationController(DeleteBaseLocationUseCase deleteRentalCompanyUseCase) {
        this.deleteRentalCompanyUseCase = deleteRentalCompanyUseCase;
    }

    @DeleteMapping("/rentalCompanies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseLocationPublicData deleteRentalCompany(@PathVariable Long id) throws BaseLocationNotFoundException {
        return new BaseLocationPublicData(deleteRentalCompanyUseCase.execute(id));
    }

}
