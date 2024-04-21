package com.rms.resourcemanagement.infrastructure.ico.dto;

import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.usecase.ico.dto.IIcoPublicData;

public record IcoPublicData(
        String id,

        String username,

        String name,

        String email,

        String phoneNumber
) implements IIcoPublicData {
        public IcoPublicData(Ico customer) {
                this(
                        customer.getId().toString(),
                        customer.getUsername(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhoneNumber()
                );
        }
}