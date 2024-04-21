package com.rms.resourcemanagement.infrastructure.ico.controller;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.usecase.ico.DeleteIcoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeleteIcoController {

    private final DeleteIcoUseCase deleteCustomerUseCase;

    public DeleteIcoController(DeleteIcoUseCase deleteCustomerUseCase) {
        this.deleteCustomerUseCase = deleteCustomerUseCase;
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public IcoPublicData deleteCustomer(@PathVariable Long id) throws IcoNotFoundException {
        return new IcoPublicData(deleteCustomerUseCase.execute(id));
    }

}
