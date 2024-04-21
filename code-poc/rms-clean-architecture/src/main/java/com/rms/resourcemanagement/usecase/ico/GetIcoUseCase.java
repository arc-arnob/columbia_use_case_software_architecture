package com.rms.resourcemanagement.usecase.ico;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;

// @Service
public class GetIcoUseCase {
    private final IcoGateway customerGateway;

    public GetIcoUseCase(IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Ico execute(Long id) throws IcoNotFoundException {
        return this.customerGateway
                .findById(id)
                .orElseThrow(IcoNotFoundException::new);
    }

}
