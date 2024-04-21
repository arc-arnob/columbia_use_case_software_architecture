package com.rms.resourcemanagement.entity.baselocation.gateway;


import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;

import java.util.List;
import java.util.Optional;

public interface BaseLocationGateway {
    BaseLocation create(BaseLocation rentalCompany);
    BaseLocation update(BaseLocation rentalCompany);
    void delete(Long id);

    Optional<BaseLocation> findById(Long id);

    Optional<BaseLocation> findByCnpj(String cnpj);
    Optional<BaseLocation> findByName(String name);

    List<String> findAllCities();

    List<BaseLocation> findAllByCity(String city);

    List<BaseLocation> findAll();
}
