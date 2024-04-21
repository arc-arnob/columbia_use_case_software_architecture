package com.rms.resourcemanagement.usecase.rental;

import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;

import java.util.List;

// @Service
public class SearchRentalsUseCase {
    private final RentalGateway rentalGateway;

    public SearchRentalsUseCase(RentalGateway rentalGateway) {
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute() {
        return this.rentalGateway.findAll();
    }


}
