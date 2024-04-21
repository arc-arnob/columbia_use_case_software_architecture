package com.rms.resourcemanagement.usecase.rental;

import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

import java.util.List;

// @Service
public class ListRentalsByBaseLocationUseCase {
    private final BaseLocationGateway rentalCompanyGateway;
    private final RentalGateway rentalGateway;

    public ListRentalsByBaseLocationUseCase(RentalGateway rentalGateway, BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
        this.rentalGateway = rentalGateway;
    }

    public List<Rental> execute(Long rentalCompanyId) throws BaseLocationNotFoundException {

        BaseLocation rentalCompany = this.rentalCompanyGateway.findById(rentalCompanyId)
                .orElseThrow(BaseLocationNotFoundException::new);

        return this.rentalGateway.findAllByRentableBase(rentalCompany);
    }

}
