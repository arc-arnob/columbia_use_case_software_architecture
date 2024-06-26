package com.rms.resourcemanagement.usecase.baselocation.dto;

import java.util.List;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IBaseLocationListingDataCities {

    List<String> cities();
}
