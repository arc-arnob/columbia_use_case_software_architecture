package com.rms.resourcemanagement.usecase.admin;

import com.rms.resourcemanagement.entity.admin.exception.AdminNotFoundException;
import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.admin.model.Admin;
import com.rms.resourcemanagement.usecase.admin.dto.IAdminUpdateData;

// @Service
public class UpdateAdminUseCase {
    private final AdminGateway adminGateway;

    public UpdateAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id, IAdminUpdateData dados) throws AdminNotFoundException {
        Admin customer = this.adminGateway.findById(id)
                .orElseThrow(AdminNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            customer.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            customer.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            customer.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            customer.setEmail(dados.email());

        return this.adminGateway.update(customer);
    }

}
