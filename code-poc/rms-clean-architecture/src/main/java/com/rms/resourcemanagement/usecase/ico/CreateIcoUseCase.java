package com.rms.resourcemanagement.usecase.ico;

import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.ico.model.Sex;
import com.rms.resourcemanagement.usecase.ico.dto.IIcoRegistrationData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateIcoUseCase {
    private final IcoGateway customerGateway;

    public CreateIcoUseCase(IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Ico execute(IIcoRegistrationData dados) {

        Ico customer = new Ico(dados.username(), dados.password(), dados.name(),
            dados.email(), dados.cpf(), dados.phoneNumber(), Sex.valueOf(dados.sex()),
            LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return this.customerGateway.create(customer);
    }


}
