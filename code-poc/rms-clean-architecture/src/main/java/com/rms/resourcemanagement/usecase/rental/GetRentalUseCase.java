package com.rms.resourcemanagement.usecase.rental;

import com.rms.resourcemanagement.entity.rental.exception.RentalNotFoundException;
import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;

// @Service
public class GetRentalUseCase {
    private final RentalGateway rentalGateway;

    public GetRentalUseCase(RentalGateway rentalGateway) {
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(Long id) throws RentalNotFoundException {
        return this.rentalGateway
                .findById(id)
                .orElseThrow(RentalNotFoundException::new);
    }

}
