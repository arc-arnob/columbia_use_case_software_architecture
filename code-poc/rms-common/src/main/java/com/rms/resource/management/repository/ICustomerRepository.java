package com.rms.resource.management.repository;

import com.rms.resource.management.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
  Customer findByCpf(String cpf);

  Collection<Customer> findAllByCpf(String cpf);
}
