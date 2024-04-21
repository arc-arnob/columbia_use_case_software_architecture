package com.rms.resourcemanagement.infrastructure.admin.controller;

import com.rms.resourcemanagement.entity.admin.exception.AdminNotFoundException;
import com.rms.resourcemanagement.entity.admin.model.Admin;
import com.rms.resourcemanagement.infrastructure.admin.dto.AdminPublicData;
import com.rms.resourcemanagement.usecase.admin.GetAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAdminController {

    private final GetAdminUseCase getAdminUseCase;

    public GetAdminController(GetAdminUseCase getAdminUseCase) {
        this.getAdminUseCase = getAdminUseCase;
    }

    @GetMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminPublicData getAdmin(@PathVariable Long id) throws AdminNotFoundException {
        Admin admin = getAdminUseCase.execute(id);

        return new AdminPublicData(admin);
    }

}
