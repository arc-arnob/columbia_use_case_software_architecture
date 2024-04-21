package com.rms.resourcemanagement.entity.rental.exception;

public class RentalNotFoundException extends Exception {

    public RentalNotFoundException() {
        super("A locação não foi encontrado!");
    }
}
