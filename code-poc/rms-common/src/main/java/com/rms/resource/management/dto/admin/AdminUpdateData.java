package com.rms.resource.management.dto.admin;

import com.rms.resource.management.validation.formats.user.Name;
import jakarta.validation.constraints.Email;

public record AdminUpdateData(
    String username,
    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email
) {
}
