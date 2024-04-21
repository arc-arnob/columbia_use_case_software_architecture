package com.rms.resource.management.dto.baseLocation;

import com.rms.resource.management.domain.BaseLocation;

public record BaseLocationPublicListingData(
    Long id, String name, String email, String city) {
  public BaseLocationPublicListingData(BaseLocation rentalCompany) {
    this(rentalCompany.getId(), rentalCompany.getName(), rentalCompany.getEmail(), rentalCompany.getCity());
  }

}
