package com.rms.resourcemanagement.infrastructure.ico.controller;

import com.rms.resourcemanagement.infrastructure.ico.dto.IcoRegistrationData;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.usecase.ico.CreateIcoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateIcoController {

    private final CreateIcoUseCase createCustomerUseCase;

    public CreateIcoController(CreateIcoUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public IcoPublicData createCustomer(@Valid @RequestBody IcoRegistrationData dados) {
        return new IcoPublicData(createCustomerUseCase.execute(dados));
    }

}
