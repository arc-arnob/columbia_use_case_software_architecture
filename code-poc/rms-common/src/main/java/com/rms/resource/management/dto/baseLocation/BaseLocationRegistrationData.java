package com.rms.resource.management.dto.baseLocation;

import com.rms.resource.management.validation.formats.baseLocation.CNPJ;
import com.rms.resource.management.validation.formats.user.Name;
import com.rms.resource.management.validation.uniques.UniqueCNPJ;
import com.rms.resource.management.validation.uniques.UniqueEmail;
import com.rms.resource.management.validation.uniques.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record BaseLocationRegistrationData(
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
    String email,

    @UniqueCNPJ(message = "{Unique.locadora.CNPJ}")
    @NotBlank
    @CNPJ(message = "{Size.locadora.CNPJ}")
    String cnpj,

    @NotBlank
    String city) {
}
