package com.rms.resource.management.repository;

import com.rms.resource.management.domain.BaseLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBaseLocationRepository extends JpaRepository<BaseLocation, Long> {
  List<BaseLocation> findAllByCnpj(String cnpj);

  BaseLocation findByCnpj(String cnpj);

  @Query("SELECT DISTINCT l.city FROM BaseLocation l")
  List<String> findAllCities();

  Page<BaseLocation> findAllByCity(String city, Pageable pageable);
}
