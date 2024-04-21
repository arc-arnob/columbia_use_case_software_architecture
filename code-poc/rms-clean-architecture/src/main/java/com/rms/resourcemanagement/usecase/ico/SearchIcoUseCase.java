package com.rms.resourcemanagement.usecase.ico;

import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;

import java.util.List;

// @Service
public class SearchIcoUseCase {
    private final IcoGateway customerGateway;

    public SearchIcoUseCase(IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public List<Ico> execute() {
        return this.customerGateway.findAll();
    }


}
