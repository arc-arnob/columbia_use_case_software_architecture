package com.rms.resourcemanagement.usecase.baselocation;

import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

// @Service
public class DeleteBaseLocationUseCase {
    private final BaseLocationGateway rentalCompanyGateway;

    public DeleteBaseLocationUseCase(BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public BaseLocation execute(Long id) throws BaseLocationNotFoundException {
        BaseLocation rentalCompany = rentalCompanyGateway.findById(id)
            .orElseThrow(BaseLocationNotFoundException::new);

        rentalCompanyGateway.delete(id);

        return rentalCompany;
    }

}
