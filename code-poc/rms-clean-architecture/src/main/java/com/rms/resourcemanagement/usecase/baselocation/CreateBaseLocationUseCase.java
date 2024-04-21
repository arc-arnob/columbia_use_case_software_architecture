package com.rms.resourcemanagement.usecase.baselocation;

import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationRegistrationData;

// @Service
public class CreateBaseLocationUseCase {
    private final BaseLocationGateway rentalCompanyGateway;

    public CreateBaseLocationUseCase(BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public BaseLocation execute(IBaseLocationRegistrationData dados) { // Liskov.

        BaseLocation rentalCompany = new BaseLocation(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cnpj(), dados.city());

        return this.rentalCompanyGateway.create(rentalCompany);
    }


}
