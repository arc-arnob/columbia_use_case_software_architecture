package com.rms.resourcemanagement.usecase.admin;

import com.rms.resourcemanagement.entity.admin.exception.AdminNotFoundException;
import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.admin.model.Admin;

// @Service
public class DeleteAdminUseCase {
    private final AdminGateway adminGateway;

    public DeleteAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public Admin execute(Long id) throws AdminNotFoundException {
        Admin admin = adminGateway.findById(id)
            .orElseThrow(AdminNotFoundException::new);

        adminGateway.delete(id);

        return admin;
    }

}
