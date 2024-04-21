package com.rms.resourcemanagement.infrastructure.admin.dto;

import com.rms.resourcemanagement.entity.admin.model.Admin;
import com.rms.resourcemanagement.usecase.admin.dto.IAdminPublicData;

public record AdminPublicData(
        String id,

        String username,

        String name,

        String email
) implements IAdminPublicData {
        public AdminPublicData(Admin admin) {
                this(
                    admin.getId().toString(),
                    admin.getUsername(),
                    admin.getName(),
                    admin.getEmail()
                );
        }
}