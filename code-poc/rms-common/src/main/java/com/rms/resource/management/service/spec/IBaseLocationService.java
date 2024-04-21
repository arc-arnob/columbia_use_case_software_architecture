package com.rms.resource.management.service.spec;

import com.rms.resource.management.domain.BaseLocation;
import com.rms.resource.management.dto.baseLocation.BaseLocationUpdateData;
import com.rms.resource.management.dto.baseLocation.BaseLocationRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseLocationService {

  BaseLocation findById(Long id);

  Page<BaseLocation> findAll(Pageable pageable);

  BaseLocation save(BaseLocationRegistrationData locadora);

  BaseLocation delete(Long id);

  BaseLocation update(Long id, BaseLocationUpdateData dados);

  Page<BaseLocation> findAllByCity(String city, Pageable pageable);

  List<String> findAllCities();
}
