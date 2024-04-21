package com.rms.resourcemanagement.usecase.admin;

import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.admin.model.Admin;

import java.util.List;

// @Service
public class SearchAdminUseCase {
    private final AdminGateway adminGateway;

    public SearchAdminUseCase(AdminGateway adminGateway) {
        this.adminGateway = adminGateway;
    }

    public List<Admin> execute() {
        return this.adminGateway.findAll();
    }


}
