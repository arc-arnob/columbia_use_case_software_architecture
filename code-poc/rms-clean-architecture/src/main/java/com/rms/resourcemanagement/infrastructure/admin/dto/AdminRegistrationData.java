package com.rms.resourcemanagement.infrastructure.admin.dto;

import com.rms.resourcemanagement.infrastructure.user.validation.formats.Name;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueEmail;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueUsername;
import com.rms.resourcemanagement.usecase.admin.dto.IAdminRegistrationData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminRegistrationData(
        @UniqueUsername(message = "{Unique.user.username}")
        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotBlank
        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @NotBlank
        @Email
        String email) implements IAdminRegistrationData { }