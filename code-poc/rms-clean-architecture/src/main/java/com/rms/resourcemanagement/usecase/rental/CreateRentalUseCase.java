package com.rms.resourcemanagement.usecase.rental;

import com.rms.resourcemanagement.entity.ico.exception.IcoNotFoundException;
import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.entity.rental.gateway.RentalGateway;
import com.rms.resourcemanagement.entity.rental.model.Rental;
import com.rms.resourcemanagement.entity.baselocation.exception.BaseLocationNotFoundException;
import com.rms.resourcemanagement.entity.baselocation.gateway.BaseLocationGateway;
import com.rms.resourcemanagement.entity.baselocation.model.BaseLocation;
import com.rms.resourcemanagement.usecase.rental.dto.IRentalRegistrationData;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// @Service
public class CreateRentalUseCase {
    private final IcoGateway customerGateway;
    private final BaseLocationGateway rentalCompanyGateway;
    private final RentalGateway rentalGateway;

    public CreateRentalUseCase(RentalGateway rentalGateway, BaseLocationGateway rentalCompanyGateway, IcoGateway customerGateway) {
        this.customerGateway = customerGateway;
        this.rentalCompanyGateway = rentalCompanyGateway;
        this.rentalGateway = rentalGateway;
    }

    public Rental execute(IRentalRegistrationData dados) throws IcoNotFoundException, BaseLocationNotFoundException {

        Ico customer = this.customerGateway.findById(dados.customerId())
                .orElseThrow(IcoNotFoundException::new);

        BaseLocation rentalCompany = this.rentalCompanyGateway.findById(dados.rentalCompanyId())
                .orElseThrow(BaseLocationNotFoundException::new);

        Rental rental = new Rental(LocalTime.parse(dados.hour(), DateTimeFormatter.ofPattern("HH:00")),
                                        LocalDate.parse(dados.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            rentalCompany,
                customer);

        return this.rentalGateway.create(rental);
    }


}
