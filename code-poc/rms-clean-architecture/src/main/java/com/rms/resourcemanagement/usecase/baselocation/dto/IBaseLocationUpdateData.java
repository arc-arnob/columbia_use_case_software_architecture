package com.rms.resourcemanagement.usecase.baselocation.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IBaseLocationUpdateData {

    String username();

    String password();

    String name();

    String email();

    String cnpj();

    String city();
}
