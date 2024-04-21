package com.rms.resource.management.dto.customer;

import com.rms.resource.management.domain.Customer;

public record CustomerPublicData(
    Long id, String username, String name, String email, String phoneNumber) {
  public CustomerPublicData(Customer customer) {
    this(customer.getId(), customer.getUsername(), customer.getName(), customer.getEmail(), customer.getPhoneNumber());
  }

}
