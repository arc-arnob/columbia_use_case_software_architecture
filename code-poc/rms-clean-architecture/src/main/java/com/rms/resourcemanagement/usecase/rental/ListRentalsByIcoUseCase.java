package com.rms.resourcemanagement.usecase.rental;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;

import java.util.List;

// @Service
public class ListRentalsByIcoUseCase {
    private final IcoGateway customerGateway;
    private final RentalGateway rentalGateway;

    public ListRentalsByIcoUseCase(RentalGateway rentalGateway, IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute(Long customerId) throws IcoNotFoundException {

        Ico customer = this.customerGateway.findById(customerId)
                .orElseThrow(IcoNotFoundException::new);

        return this.rentalGateway.findAllByCustomer(customer);
    }

}
