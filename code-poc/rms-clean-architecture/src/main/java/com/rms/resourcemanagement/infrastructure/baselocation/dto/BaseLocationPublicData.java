package com.rms.resourcemanagement.infrastructure.baselocation.dto;

import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.usecase.baselocation.dto.IBaseLocationPublicData;

public record BaseLocationPublicData(
        String id,

        String username,

        String name,

        String email,

        String city
) implements IBaseLocationPublicData {
        public BaseLocationPublicData(BaseLocation rentalCompany) {
                this(
                        rentalCompany.getId().toString(),
                        rentalCompany.getUsername(),
                        rentalCompany.getName(),
                        rentalCompany.getEmail(),
                        rentalCompany.getCity()
                );
        }

}