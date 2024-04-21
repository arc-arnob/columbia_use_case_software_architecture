package com.rms.resourcemanagement.usecase.ico;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;

// @Service
public class DeleteIcoUseCase {
    private final IcoGateway customerGateway;

    public DeleteIcoUseCase(IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Ico execute(Long id) throws IcoNotFoundException {
        Ico customer = customerGateway.findById(id)
            .orElseThrow(IcoNotFoundException::new);

        customerGateway.delete(id);

        return customer;
    }

}
