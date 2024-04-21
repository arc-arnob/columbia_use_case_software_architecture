package com.rms.resourcemanagement.infrastructure.admin.controller;

import com.rms.resourcemanagement.entity.admin.exception.AdminNotFoundException;
import com.rms.resourcemanagement.infrastructure.admin.dto.AdminPublicData;
import com.rms.resourcemanagement.usecase.admin.DeleteAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteAdminController {

    private final DeleteAdminUseCase deleteAdminUserCase;

    public DeleteAdminController(DeleteAdminUseCase deleteAdminUserCase) {
        this.deleteAdminUserCase = deleteAdminUserCase;
    }

    @DeleteMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData deleteAdmin(@PathVariable Long id) throws AdminNotFoundException {
        return new AdminPublicData(deleteAdminUserCase.execute(id));
    }

}
