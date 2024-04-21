package com.rms.resourcemanagement.usecase.admin;

import com.rms.resourcemanagement.entity.admin.exception.AdminNotFoundException;
import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.admin.model.Admin;

// @Service
public class GetAdminUseCase {
    private final AdminGateway adminGateway;

    public GetAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id) throws AdminNotFoundException {
        return this.adminGateway
                .findById(id)
                .orElseThrow(AdminNotFoundException::new);
    }

}
