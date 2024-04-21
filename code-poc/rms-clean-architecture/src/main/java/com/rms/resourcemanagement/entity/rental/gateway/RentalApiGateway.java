package com.rms.resourcemanagement.entity.rental.gateway;

import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.rental.model.Rental;

import java.util.List;
import java.util.Optional;

public class RentalApiGateway implements RentalGateway {


    @Override
    public Rental create(Rental rental) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Rental> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Rental> findAllByRentableBase(BaseLocation rentalCompany) {
        return null;
    }

    @Override
    public List<Rental> findAllByCustomer(Ico customer) {
        return null;
    }

    @Override
    public List<Rental> findAll() {
        return null;
    }
}