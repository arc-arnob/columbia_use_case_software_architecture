package com.rms.resource.management.dto.baseLocation;

import com.rms.resource.management.domain.BaseLocation;
import com.rms.resource.management.dto.rental.RentalDetailsRentalCompany;

import java.util.List;

public record BaseLocationDetails(
    Long id, String username, String name, String email,
    String cnpj, String city, List<RentalDetailsRentalCompany> locacoes) {
  public BaseLocationDetails(BaseLocation rentalCompany) {
    this(rentalCompany.getId(), rentalCompany.getUsername(), rentalCompany.getName(), rentalCompany.getEmail(),
        rentalCompany.getCnpj(), rentalCompany.getCity(),
        rentalCompany.getLocacoes() != null ? rentalCompany.getLocacoes().stream().map(RentalDetailsRentalCompany::new).toList() : List.of());
  }

}
