package com.rms.resourcemanagement.infrastructure.ico.controller;

import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.infrastructure.ico.dto.IcoPublicData;
import com.rms.resourcemanagement.usecase.ico.SearchIcoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchIcoController {

    private final SearchIcoUseCase searchCustomerUseCase;

    public SearchIcoController(SearchIcoUseCase searchCustomerUseCase) {
        this.searchCustomerUseCase = searchCustomerUseCase;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<IcoPublicData> searchCustomers() {
        List<Ico> customers = this.searchCustomerUseCase.execute();

        return customers.stream().map(IcoPublicData::new).toList();
    }

}
