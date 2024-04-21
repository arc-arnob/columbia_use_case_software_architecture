package com.rms.resourcemanagement.usecase.baselocation;

import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

// @Service
public class GetBaseLocationUseCase {
    private final BaseLocationGateway rentalCompanyGateway;

    public GetBaseLocationUseCase(BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public BaseLocation execute(Long id) throws BaseLocationNotFoundException {
        return this.rentalCompanyGateway
                .findById(id)
                .orElseThrow(BaseLocationNotFoundException::new);
    }

}
