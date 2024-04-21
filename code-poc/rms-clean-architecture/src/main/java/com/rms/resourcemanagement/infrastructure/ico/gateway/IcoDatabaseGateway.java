package com.rms.resourcemanagement.infrastructure.ico.gateway;

import com.rms.resourcemanagement.entity.ico.gateway.IcoGateway;
import com.rms.resourcemanagement.entity.ico.model.Ico;
import com.rms.resourcemanagement.infrastructure.config.db.repository.IcoRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.CustomerSchema;

import java.util.List;
import java.util.Optional;

public class IcoDatabaseGateway implements IcoGateway {

    private final IcoRepository customerRepository;

    public IcoDatabaseGateway(IcoRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Ico create(Ico customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public Ico update(Ico customer) {
        return this.customerRepository.save(new CustomerSchema(customer)).toCustomer();
    }

    @Override
    public void delete(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Optional<Ico> findById(Long id) {
        return customerRepository
                .findById(id)
                .map(CustomerSchema::toCustomer);
    }

    @Override
    public Optional<Ico> findByCpf(String cpf) {
        return customerRepository
                .findByCpf(cpf)
                .map(CustomerSchema::toCustomer);
    }

    @Override
    public List<Ico> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(CustomerSchema::toCustomer)
                .toList();
    }
}
