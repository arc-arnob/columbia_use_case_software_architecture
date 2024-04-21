package com.rms.resourcemanagement.infrastructure.baselocation.gateway;

import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.infrastructure.config.db.repository.RentalCompanyRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.BaseLocationSchema;

import java.util.List;
import java.util.Optional;

public class BaseLocationDatabaseGateway implements BaseLocationGateway {

    private final RentalCompanyRepository rentalCompanyRepository;

    public BaseLocationDatabaseGateway(RentalCompanyRepository rentalCompanyRepository) {
        this.rentalCompanyRepository = rentalCompanyRepository;
    }


    @Override
    public BaseLocation create(BaseLocation rentalCompany) {
        return this.rentalCompanyRepository.save(new BaseLocationSchema(rentalCompany)).toRentalCompany();
    }

    @Override
    public BaseLocation update(BaseLocation rentalCompany) {
        return this.rentalCompanyRepository.save(new BaseLocationSchema(rentalCompany)).toRentalCompany();
    }

    @Override
    public void delete(Long id) {
        this.rentalCompanyRepository.deleteById(id);
    }

    @Override
    public Optional<BaseLocation> findById(Long id) {
        return rentalCompanyRepository
                .findById(id)
                .map(BaseLocationSchema::toRentalCompany);
    }


    @Override
    public Optional<BaseLocation> findByCnpj(String cnpj) {
        return this.rentalCompanyRepository.findByCnpj(cnpj).map(BaseLocationSchema::toRentalCompany);
    }

    @Override
    public Optional<BaseLocation> findByName(String name) {
        return this.rentalCompanyRepository.findByName(name).map(BaseLocationSchema::toRentalCompany);
    }

    @Override
    public List<String> findAllCities() {
        return this.rentalCompanyRepository.findAllCities();
    }

    @Override
    public List<BaseLocation> findAllByCity(String city) {
        return this.rentalCompanyRepository.findAllByCity(city).stream().map(BaseLocationSchema::toRentalCompany).toList();
    }

    @Override
    public List<BaseLocation> findAll() {
        return rentalCompanyRepository
                .findAll()
                .stream()
                .map(BaseLocationSchema::toRentalCompany)
                .toList();
    }
}
