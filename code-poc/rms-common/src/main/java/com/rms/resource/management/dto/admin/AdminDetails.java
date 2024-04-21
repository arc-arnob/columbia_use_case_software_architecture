package com.rms.resource.management.dto.admin;

import com.rms.resource.management.domain.Admin;

public record AdminDetails(Long id, String username, String name, String email) {
    public AdminDetails(Admin admin) {
        this(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail());
    }

}
