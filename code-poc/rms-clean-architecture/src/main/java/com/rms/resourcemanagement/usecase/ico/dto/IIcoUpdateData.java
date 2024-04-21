package com.rms.resourcemanagement.usecase.ico.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IIcoUpdateData {

    String username();

    String password();

    String name();

    String email();

    String cpf();

    String phoneNumber();

    String sex();

    String birthdate();
}
