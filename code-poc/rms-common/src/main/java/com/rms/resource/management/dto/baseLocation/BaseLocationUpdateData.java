package com.rms.resource.management.dto.baseLocation;

import com.rms.resource.management.validation.formats.baseLocation.CNPJ;
import com.rms.resource.management.validation.formats.user.Name;
import jakarta.validation.constraints.Email;

public record BaseLocationUpdateData(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @CNPJ(message = "{Size.locadora.CNPJ}")
    String cnpj,

    String city) {
}
