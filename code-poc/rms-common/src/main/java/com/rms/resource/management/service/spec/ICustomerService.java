package com.rms.resource.management.service.spec;

import com.rms.resource.management.domain.Customer;
import com.rms.resource.management.dto.customer.CUstomerUpdateData;
import com.rms.resource.management.dto.customer.CustomerRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

  Customer findById(Long id);

  Page<Customer> findAll(Pageable pageable);

  Customer save(CustomerRegistrationData customer);

  Customer delete(Long id);

  Customer update(Long id, CUstomerUpdateData dados);
}
