package com.rms.resourcemanagement.infrastructure.ico.dto;

import com.rms.resourcemanagement.infrastructure.ico.validation.formats.BirthDateField;
import com.rms.resourcemanagement.infrastructure.ico.validation.formats.CPF;
import com.rms.resourcemanagement.infrastructure.ico.validation.unique.UniqueCPF;
import com.rms.resourcemanagement.infrastructure.user.validation.formats.Name;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueEmail;
import com.rms.resourcemanagement.infrastructure.user.validation.unique.UniqueUsername;
import com.rms.resourcemanagement.usecase.ico.dto.IIcoUpdateData;
import com.rms.resourcemanagement.infrastructure.ico.validation.formats.PhoneNumber;
import com.rms.resourcemanagement.infrastructure.ico.validation.formats.Sex;
import jakarta.validation.constraints.Email;

public record IcoUpdateData(
        @UniqueUsername(message = "{Unique.user.username}")
        String username,

        String password,

        @Name(message = "{Name.user.name}")
        String name,

        @UniqueEmail(message = "{Unique.user.email}")
        @Email
        String email,

        @UniqueCPF(message = "{Unique.customer.CPF}")
        @CPF(message = "{Size.customer.CPF}")
        String cpf,

        @PhoneNumber(message = "{Size.customer.phone}")
        String phoneNumber,

        @Sex(message = "{Sex.customer}")
        String sex,

        @BirthDateField(message = "{BirthDate.customer}")
        String birthdate) implements IIcoUpdateData {
}
