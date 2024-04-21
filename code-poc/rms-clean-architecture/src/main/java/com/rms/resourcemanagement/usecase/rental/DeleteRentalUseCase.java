package com.rms.resourcemanagement.usecase.rental;

import com.rms.resourcemanagement.entity.rental.exception.RentalNotFoundException;
import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;

// @Service
public class DeleteRentalUseCase {
    private final RentalGateway rentalGateway;

    public DeleteRentalUseCase(RentalGateway rentalGateway) {
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(Long id) throws RentalNotFoundException {
        Rental rental = rentalGateway.findById(id)
            .orElseThrow(RentalNotFoundException::new);

        rentalGateway.delete(id);

        return rental;
    }

}
