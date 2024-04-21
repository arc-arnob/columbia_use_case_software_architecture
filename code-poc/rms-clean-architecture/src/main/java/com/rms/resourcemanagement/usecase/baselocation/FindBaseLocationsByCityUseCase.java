package com.rms.resourcemanagement.usecase.baselocation;

import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

import java.util.List;

// @Service
public class FindBaseLocationsByCityUseCase {
    private final BaseLocationGateway rentalCompanyGateway;

    public FindBaseLocationsByCityUseCase(BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public List<BaseLocation> execute(String city) {

        return this.rentalCompanyGateway.findAllByCity(city);
    }

}
