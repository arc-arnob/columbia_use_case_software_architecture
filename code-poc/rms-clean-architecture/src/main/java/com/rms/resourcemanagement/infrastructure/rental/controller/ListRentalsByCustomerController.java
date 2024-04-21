package com.rms.resourcemanagement.infrastructure.rental.controller;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.infrastructure.rental.dto.RentalPublicData;
import com.rms.resourcemanagement.usecase.rental.ListRentalsByIcoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRentalsByCustomerController {

    private final ListRentalsByIcoUseCase listRentalsByCustomerUseCase;

    public ListRentalsByCustomerController(ListRentalsByIcoUseCase listRentalsByCustomerUseCase) {
        this.listRentalsByCustomerUseCase = listRentalsByCustomerUseCase;
    }

    @GetMapping("/rentals/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<RentalPublicData> listRentalsByCustomer(@PathVariable Long customerId) throws IcoNotFoundException {
        List<Rental> rentals = this.listRentalsByCustomerUseCase.execute(customerId);

        return rentals.stream().map(RentalPublicData::new).toList();
    }

}
