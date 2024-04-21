package com.rms.resourcemanagement.usecase.ico.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IIcoPublicData {

    String id();

    String username();

    String name();

    String email();

    String phoneNumber();

}
