package com.rms.resource.management.dto.customer;

import com.rms.resource.management.validation.formats.customer.BirthDateField;
import com.rms.resource.management.validation.formats.customer.CPF;
import com.rms.resource.management.validation.formats.customer.PhoneNumber;
import com.rms.resource.management.validation.formats.customer.Sex;
import com.rms.resource.management.validation.formats.user.Name;
import com.rms.resource.management.validation.uniques.UniqueCPF;
import com.rms.resource.management.validation.uniques.UniqueEmail;
import com.rms.resource.management.validation.uniques.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRegistrationData(
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
    @CPF(message = "{Size.customer.CPF}")
    String cpf,

    @NotBlank
    @PhoneNumber(message = "{Size.customer.phone}")
    String phoneNumber,

    @Sex(message = "{Sex.customer}")
    @NotBlank
    String sex,

    @BirthDateField(message = "{BirthDate.customer}")
    @NotNull
    String birthdate) {
}
