package com.rms.resourcemanagement.infrastructure.baselocation.dto;

import com.rms.resourcemanagement.infrastructure.baselocation.validation.formats.CNPJ;
import com.rms.resourcemanagement.infrastructure.baselocation.validation.unique.UniqueCNPJ;
import com.rms.resourcemanagement.infrastructure.user.validation.formats.Name;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueEmail;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueUsername;
import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationUpdateData;
import jakarta.validation.constraints.Email;

public record BaseLocationUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCNPJ(message = "{Unique.rentalCompany.CNPJ}")
        @CNPJ(message = "{Size.rentalCompany.CNPJ}")
        String cnpj,

        String city) implements IBaseLocationUpdateData {
}
