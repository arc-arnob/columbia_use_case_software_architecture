package com.rms.resourcemanagement.infrastructure.rental.controller;

import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.infrastructure.rental.dto.RentalPublicData;
import com.rms.resourcemanagement.usecase.rental.ListRentalsByBaseLocationUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRentalsByRentalCompanyController {

    private final ListRentalsByBaseLocationUseCase listRentalsUseCase;

    public ListRentalsByRentalCompanyController(ListRentalsByBaseLocationUseCase listRentalsUseCase) {
        this.listRentalsUseCase = listRentalsUseCase;
    }

    @GetMapping("/rentals/rentalCompanies/{rentalCompanyId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalPublicData> searchRentalsByRentalCompany(@PathVariable Long rentalCompanyId) throws
            BaseLocationNotFoundException {
        List<Rental> rentals = this.listRentalsUseCase.execute(rentalCompanyId);

        return rentals.stream().map(RentalPublicData::new).toList();
    }

}
