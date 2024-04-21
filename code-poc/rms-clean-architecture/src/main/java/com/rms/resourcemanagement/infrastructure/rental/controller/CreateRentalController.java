package com.rms.resourcemanagement.infrastructure.rental.controller;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.infrastructure.rental.dto.RentalRegistrationData;
import com.rms.resourcemanagement.infrastructure.rental.dto.RentalPublicData;
import com.rms.resourcemanagement.usecase.rental.CreateRentalUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateRentalController {

    private final CreateRentalUseCase createRentalUseCase;

    public CreateRentalController(CreateRentalUseCase createRentalUseCase) {
        this.createRentalUseCase = createRentalUseCase;
    }

    @PostMapping("/rentals")
    @ResponseStatus(HttpStatus.CREATED)
    public RentalPublicData createRental(@Valid @RequestBody RentalRegistrationData dados) throws IcoNotFoundException, BaseLocationNotFoundException {
        return new RentalPublicData(createRentalUseCase.execute(dados));
    }

}
