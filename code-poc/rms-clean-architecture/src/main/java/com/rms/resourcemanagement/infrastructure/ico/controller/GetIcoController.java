package com.rms.resourcemanagement.infrastructure.ico.controller;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.usecase.ico.GetIcoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetIcoController {

    private final GetIcoUseCase getCustomerUseCase;

    public GetIcoController(GetIcoUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public IcoPublicData getCustomer(@PathVariable Long id) throws IcoNotFoundException {
        Ico customer = getCustomerUseCase.execute(id);

        return new IcoPublicData(customer);
    }

}
