package com.rms.resourcemanagement.entity.rental.gateway;


import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

import java.util.List;
import java.util.Optional;

public interface RentalGateway {
    Rental create(Rental rental);
    void delete(Long id);

    Optional<Rental> findById(Long id);

    List<Rental> findAllByRentableBase(BaseLocation rentalCompany);

    List<Rental> findAllByCustomer(Ico customer);

    List<Rental> findAll();
}
