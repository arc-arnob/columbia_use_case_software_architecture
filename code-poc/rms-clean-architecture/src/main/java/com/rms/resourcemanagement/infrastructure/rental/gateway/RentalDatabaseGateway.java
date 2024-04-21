package com.rms.resourcemanagement.infrastructure.rental.gateway;

import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.infrastructure.config.db.repository.RentalRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.CustomerSchema;
import com.rms.resourcemanagement.infrastructure.config.db.schema.RentalSchema;
import com.rms.resourcemanagement.infrastructure.config.db.schema.BaseLocationSchema;

import java.util.List;
import java.util.Optional;

public class RentalDatabaseGateway implements RentalGateway {

    private final RentalRepository rentalRepository;

    public RentalDatabaseGateway(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental create(Rental rental) {
        return this.rentalRepository.save(new RentalSchema(rental)).toRental();
    }

    @Override
    public void delete(Long id) {
        this.rentalRepository.deleteById(id);
    }

    @Override
    public Optional<Rental> findById(Long id) {
        return rentalRepository
                .findById(id)
                .map(RentalSchema::toRental);
    }


    @Override
    public List<Rental> findAllByRentableBase(BaseLocation rentalCompany) {
        return this.rentalRepository.findAllByRentalCompany(new BaseLocationSchema(rentalCompany))
                .stream()
                .map(RentalSchema::toRental)
                .toList();
    }

    @Override
    public List<Rental> findAllByCustomer(Ico customer) {
        return this.rentalRepository.findAllByCustomer(new CustomerSchema(customer))
                .stream()
                .map(RentalSchema::toRental)
                .toList();
    }


    @Override
    public List<Rental> findAll() {
        return rentalRepository
                .findAll()
                .stream()
                .map(RentalSchema::toRental)
                .toList();
    }
}