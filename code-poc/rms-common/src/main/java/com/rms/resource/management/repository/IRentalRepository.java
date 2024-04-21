package com.rms.resource.management.repository;

import com.rms.resource.management.domain.Customer;
import com.rms.resource.management.domain.Rental;
import com.rms.resource.management.domain.BaseLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentalRepository extends JpaRepository<Rental, Long> {
  Page<Rental> findAllByRentalCompany(BaseLocation rentalCompany, Pageable pageable);

  Page<Rental> findAllByCustomer(Customer customer, Pageable pageable);

  List<Rental> findAllByCustomer(Customer customer);
}
