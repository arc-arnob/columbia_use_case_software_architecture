package com.rms.resourcemanagement.usecase.ico;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.ico.model.Sex;
import com.rms.resourcemanagement.usecase.ico.dto.IIcoUpdateData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// @Service
public class UpdateIcoUseCase {
    private final IcoGateway customerGateway;

    public UpdateIcoUseCase(IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Ico execute(Long id, IIcoUpdateData dados) throws IcoNotFoundException {
        Ico customer = this.customerGateway.findById(id)
                .orElseThrow(IcoNotFoundException::new);

        if(dados.username() != null && !dados.username().isBlank())
            customer.setUsername(dados.username());

        if(dados.password() != null && !dados.password().isBlank())
            customer.setPassword(dados.password());

        if(dados.name() != null && !dados.name().isBlank())
            customer.setName(dados.name());

        if(dados.email() != null && !dados.email().isBlank())
            customer.setEmail(dados.email());

        if(dados.cpf() != null && !dados.cpf().isBlank())
            customer.setCpf(dados.cpf());

        if(dados.phoneNumber() != null && !dados.phoneNumber().isBlank())
            customer.setPhoneNumber(dados.phoneNumber());

        if(dados.sex() != null && !dados.sex().isBlank())
            customer.setSex(Sex.valueOf(dados.sex()));

        if(dados.birthdate() != null && !dados.birthdate().isBlank())
            customer.setBirthdate(LocalDate.parse(dados.birthdate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));


        return this.customerGateway.update(customer);
    }

}
