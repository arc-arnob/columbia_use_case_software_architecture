package com.rms.resourcemanagement.infrastructure.baselocation.dto;

import com.rms.resourcemanagement.infrastructure.baselocation.validation.formats.CNPJ;
import com.rms.resourcemanagement.infrastructure.baselocation.validation.unique.UniqueCNPJ;
import com.rms.resourcemanagement.infrastructure.user.validation.formats.Name;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueEmail;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueUsername;
import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationRegistrationData;
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

        @UniqueCNPJ(message = "{Unique.rentalCompany.CNPJ}")
        @NotBlank
        @CNPJ(message = "{Size.rentalCompany.CNPJ}")
        String cnpj,

        @NotBlank
        String city) implements IBaseLocationRegistrationData { }