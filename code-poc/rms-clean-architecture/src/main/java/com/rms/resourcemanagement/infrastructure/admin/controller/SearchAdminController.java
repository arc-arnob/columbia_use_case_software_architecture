package com.rms.resourcemanagement.infrastructure.admin.controller;

import com.rms.resourcemanagement.entity.admin.model.Admin;
import com.rms.resourcemanagement.infrastructure.admin.dto.AdminPublicData;
import com.rms.resourcemanagement.usecase.admin.SearchAdminUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchAdminController {

    private final SearchAdminUseCase searchAdminUseCase;

    public SearchAdminController(SearchAdminUseCase searchAdminUseCase) {
        this.searchAdminUseCase = searchAdminUseCase;
    }

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<AdminPublicData> searchAdmin() {
        List<Admin> admins = this.searchAdminUseCase.execute();

        return admins.stream().map(AdminPublicData::new).toList();
    }

}
