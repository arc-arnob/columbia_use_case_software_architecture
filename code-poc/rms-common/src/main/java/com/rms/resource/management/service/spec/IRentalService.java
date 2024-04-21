package com.rms.resource.management.service.spec;

import com.rms.resource.management.domain.Customer;
import com.rms.resource.management.domain.Rental;
import com.rms.resource.management.domain.BaseLocation;
import com.rms.resource.management.dto.rental.RentalRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRentalService {

  Rental findById(Long id);

  Page<Rental> findAllByRentalCompany(Pageable pageable, BaseLocation rentalCompany);

  Page<Rental> findAllByCustomer(Pageable pageable, Customer customer);

  Page<Rental> findAll(Pageable pageable);

  Rental save(RentalRegistrationData rental);

  Rental delete(Long id);

  Page<Rental> findAllByLocadora(Long id, Pageable pageable);

  Page<Rental> findAllByCustomer(Long id, Pageable pageable);
}
