package com.rms.resourcemanagement.infrastructure.admin.controller;

import com.rms.resourcemanagement.infrastructure.admin.dto.AdminRegistrationData;
import com.rms.resourcemanagement.infrastructure.admin.dto.AdminPublicData;
import com.rms.resourcemanagement.usecase.admin.CreateAdminUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAdminController {

    private final CreateAdminUseCase createAdminUseCase;

    public CreateAdminController(CreateAdminUseCase createAdminUseCase) {
        this.createAdminUseCase = createAdminUseCase;
    }

    @PostMapping("/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminPublicData createAdmin(@Valid @RequestBody AdminRegistrationData dados) {
        return new AdminPublicData(createAdminUseCase.execute(dados));
    }

}
