package com.rms.resource.management.dto.admin;

import com.rms.resource.management.validation.formats.user.Name;
import com.rms.resource.management.validation.uniques.UniqueEmail;
import com.rms.resource.management.validation.uniques.UniqueUsername;
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
    String email) {
}
