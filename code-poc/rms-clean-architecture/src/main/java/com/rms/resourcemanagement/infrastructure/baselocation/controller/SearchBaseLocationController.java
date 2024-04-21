package com.rms.resourcemanagement.infrastructure.baselocation.controller;

import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.baselocation.SearchBaseLocationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchBaseLocationController {

    private final SearchBaseLocationUseCase searchRentalCompanyUseCase;

    public SearchBaseLocationController(SearchBaseLocationUseCase searchRentalCompanyUseCase) {
        this.searchRentalCompanyUseCase = searchRentalCompanyUseCase;
    }

    @GetMapping("/rentalCompanies")
    @ResponseStatus(HttpStatus.OK)
    public List<BaseLocationPublicData> searchRentalCompanies() {
        List<BaseLocation> rentalCompanies = this.searchRentalCompanyUseCase.execute();

        return rentalCompanies.stream().map(BaseLocationPublicData::new).toList();
    }

}
