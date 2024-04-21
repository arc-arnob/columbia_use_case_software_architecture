package com.rms.resourcemanagement.infrastructure.ico.controller;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoUpdateData;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.usecase.ico.UpdateIcoUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateIcoController {

    private final UpdateIcoUseCase updateCustomerUseCase;

    public UpdateIcoController(UpdateIcoUseCase updateCustomerUseCase) {
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IcoPublicData createCustomer(@PathVariable Long id, @Valid @RequestBody IcoUpdateData dados) throws IcoNotFoundException {
        return new IcoPublicData(updateCustomerUseCase.execute(id, dados));
    }

}
