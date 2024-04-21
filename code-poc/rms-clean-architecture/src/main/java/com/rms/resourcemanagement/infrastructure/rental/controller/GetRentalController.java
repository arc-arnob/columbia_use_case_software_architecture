package com.rms.resourcemanagement.infrastructure.rental.controller;

import com.rms.resourcemanagement.entity.rental.exception.RentalNotFoundException;
import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.infrastructure.rental.dto.RentalPublicData;
import com.rms.resourcemanagement.usecase.rental.GetRentalUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRentalController {

    private final GetRentalUseCase getRentalUseCase;

    public GetRentalController(GetRentalUseCase getRentalUseCase) {
        this.getRentalUseCase = getRentalUseCase;
    }

    @GetMapping("/rentals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentalPublicData getRental(@PathVariable Long id) throws RentalNotFoundException {
        Rental rental = getRentalUseCase.execute(id);

        return new RentalPublicData(rental);
    }

}
