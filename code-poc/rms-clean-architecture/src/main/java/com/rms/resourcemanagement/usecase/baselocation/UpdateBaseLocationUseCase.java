package com.rms.resourcemanagement.usecase.baselocation;

import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationUpdateData;

// @Service
public class UpdateBaseLocationUseCase {
    private final BaseLocationGateway rentalCompanyGateway;

    public UpdateBaseLocationUseCase(BaseLocationGateway rentalCompanyGateway) {
        this.rentalCompanyGateway = rentalCompanyGateway;
    }

    public BaseLocation execute(Long id, IBaseLocationUpdateData dados) throws BaseLocationNotFoundException {
        BaseLocation rentalCompany = this.rentalCompanyGateway.findById(id)
                .orElseThrow(BaseLocationNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            rentalCompany.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            rentalCompany.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            rentalCompany.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            rentalCompany.setEmail(dados.email());

        if(dados.cnpj() != null && !dados.cnpj().isBlank())
            rentalCompany.setCnpj(dados.cnpj());

        if(dados.city() != null && !dados.city().isBlank())
            rentalCompany.setCity(dados.city());

        return this.rentalCompanyGateway.update(rentalCompany);
    }

}
