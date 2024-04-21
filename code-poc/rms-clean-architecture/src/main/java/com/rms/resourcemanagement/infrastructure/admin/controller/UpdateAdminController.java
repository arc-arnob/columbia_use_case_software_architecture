package com.rms.resourcemanagement.infrastructure.admin.controller;

import com.rms.resourcemanagement.entity.admin.exception.AdminNotFoundException;
import com.rms.resourcemanagement.infrastructure.admin.dto.AdminUpdateData;
import com.rms.resourcemanagement.infrastructure.admin.dto.AdminPublicData;
import com.rms.resourcemanagement.usecase.admin.UpdateAdminUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateAdminController {

    private final UpdateAdminUseCase updateAdminUseCase;

    public UpdateAdminController(UpdateAdminUseCase updateAdminUseCase) {
        this.updateAdminUseCase = updateAdminUseCase;
    }

    @PutMapping("/admins/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AdminPublicData updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminUpdateData dados) throws AdminNotFoundException {
        return new AdminPublicData(updateAdminUseCase.execute(id, dados));
    }

}
