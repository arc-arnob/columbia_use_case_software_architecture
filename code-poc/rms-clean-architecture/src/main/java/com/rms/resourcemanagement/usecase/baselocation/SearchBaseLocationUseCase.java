package com.rms.resourcemanagement.usecase.baselocation;

import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

import java.util.List;

// @Service
public class SearchBaseLocationUseCase {
    private final BaseLocationGateway rentalCompanyGateway;

    public SearchBaseLocationUseCase(BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public List<BaseLocation> execute() {
        return this.rentalCompanyGateway.findAll();
    }


}
