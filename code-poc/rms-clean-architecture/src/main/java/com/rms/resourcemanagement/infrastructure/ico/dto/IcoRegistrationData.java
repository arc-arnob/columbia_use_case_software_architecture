package com.rms.resourcemanagement.infrastructure.ico.dto;

import com.rms.resourcemanagement.infrastructure.ico.validation.formats.BirthDateField;
import com.rms.resourcemanagement.infrastructure.ico.validation.formats.CPF;
import com.rms.resourcemanagement.infrastructure.ico.validation.formats.PhoneNumber;
import com.rms.resourcemanagement.infrastructure.ico.validation.formats.Sex;
import com.rms.resourcemanagement.infrastructure.ico.validation.unique.UniqueCPF;
import com.rms.resourcemanagement.infrastructure.user.validation.formats.Name;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueEmail;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueUsername;
import com.rms.resourcemanagement.usecase.ico.dto.IIcoRegistrationData;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IcoRegistrationData(
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

        @UniqueCPF(message = "{Unique.customer.CPF}")
        @NotBlank
        @CPF(message = "{Size.customers.CPF}")
        String cpf,

        @NotBlank
        @PhoneNumber(message = "{Size.customer.phone}")
        String phoneNumber,

        @Sex(message = "{Sex.customer}")
        @NotBlank
        String sex,

        @BirthDateField(message = "{BirthDate.customer}")
        @NotNull
        String birthdate) implements IIcoRegistrationData { }