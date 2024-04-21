package com.rms.resourcemanagement.infrastructure.rental.controller;

import com.rms.resourcemanagement.entity.rental.exception.RentalNotFoundException;
import com.rms.resourcemanagement.infrastructure.rental.dto.RentalPublicData;
import com.rms.resourcemanagement.usecase.rental.DeleteRentalUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteRentalController {

    private final DeleteRentalUseCase deleteRentalUseCase;

    public DeleteRentalController(DeleteRentalUseCase deleteRentalUseCase) {
        this.deleteRentalUseCase = deleteRentalUseCase;
    }

    @DeleteMapping("/rentals/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentalPublicData deleteRental(@PathVariable Long id) throws RentalNotFoundException {
        return new RentalPublicData(deleteRentalUseCase.execute(id));
    }

}
