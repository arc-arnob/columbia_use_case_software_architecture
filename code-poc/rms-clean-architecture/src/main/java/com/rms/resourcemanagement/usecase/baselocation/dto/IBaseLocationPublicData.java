package com.rms.resourcemanagement.usecase.baselocation.dto;

// DTO (Data Transfer Object) interface to invert spring boot lib dependencies,
// respecting the decoupling of the use cases layer
public interface IBaseLocationPublicData {

    String id();

    String name();

    String email();

    String city();

}
