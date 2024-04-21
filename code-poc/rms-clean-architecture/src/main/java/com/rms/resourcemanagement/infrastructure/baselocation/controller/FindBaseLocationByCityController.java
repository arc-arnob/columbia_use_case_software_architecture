package com.rms.resourcemanagement.infrastructure.baselocation.controller;

import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.infrastructure.baselocation.dto.BaseLocationPublicData;
import com.rms.resourcemanagement.usecase.baselocation.FindBaseLocationsByCityUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindBaseLocationByCityController {

    private final FindBaseLocationsByCityUseCase findRentalCompaniesByCityUseCase;

    public FindBaseLocationByCityController(FindBaseLocationsByCityUseCase findBaseLocationsByCityUseCase) {
        this.findRentalCompaniesByCityUseCase = findBaseLocationsByCityUseCase;
    }

    @GetMapping("/rentalCompanies/cidades/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<BaseLocationPublicData> findRentalCompaniesByCity(@PathVariable String city) {
        List<BaseLocation> baseLocations = this.findRentalCompaniesByCityUseCase.execute(city);

        return baseLocations.stream().map(BaseLocationPublicData::new).toList();
    }

}
