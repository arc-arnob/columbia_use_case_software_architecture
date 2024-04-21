package com.rms.resourcemanagement.usecase.admin;

import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.admin.model.Admin;
import com.rms.resourcemanagement.usecase.admin.dto.IAdminRegistrationData;

// @Service
public class CreateAdminUseCase {
    private final AdminGateway adminGateway;

    public CreateAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(IAdminRegistrationData dados) {

        Admin admin = new Admin(dados.username(), dados.password(), dados.name(),
            dados.email());

        return this.adminGateway.create(admin);
    }


}
