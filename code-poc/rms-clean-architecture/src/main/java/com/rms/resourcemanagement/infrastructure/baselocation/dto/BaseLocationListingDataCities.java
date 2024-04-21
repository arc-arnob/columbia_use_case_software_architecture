package com.rms.resourcemanagement.infrastructure.baselocation.dto;

import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationListingDataCities;

import java.util.List;

public record BaseLocationListingDataCities(
    List<String> cities
) implements IBaseLocationListingDataCities { }