package com.rms.resourcemanagement.entity.admin.exception;

public class AdminNotFoundException extends Exception {

    public AdminNotFoundException() {
        super("O administrador não foi encontrado!");
    }
}
