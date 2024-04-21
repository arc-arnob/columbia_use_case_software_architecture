package com.rms.resource.management.dto.customer;

import com.rms.resource.management.validation.formats.customer.BirthDateField;
import com.rms.resource.management.validation.formats.customer.CPF;
import com.rms.resource.management.validation.formats.customer.PhoneNumber;
import com.rms.resource.management.validation.formats.customer.Sex;
import com.rms.resource.management.validation.formats.user.Name;
import jakarta.validation.constraints.Email;

public record CUstomerUpdateData(
    String username,

    String password,

    @Name(message = "{Name.user.name}")
    String name,

    @Email
    String email,

    @CPF(message = "{Size.customer.CPF}")
    String cpf,

    @PhoneNumber(message = "{Size.customer.phone}")
    String phoneNumber,

    @Sex(message = "{Sex.customer}")
    String sex,

    @BirthDateField(message = "{BirthDate.customer}")
    String birthdate) {
}
