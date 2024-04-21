package com.rms.resourcemanagement.infrastructure.admin.gateway;

import com.rms.resourcemanagement.entity.admin.gateway.AdminGateway;
import com.rms.resourcemanagement.entity.admin.model.Admin;
import com.rms.resourcemanagement.infrastructure.config.db.repository.AdminRepository;
import com.rms.resourcemanagement.infrastructure.config.db.schema.AdminSchema;

import java.util.List;
import java.util.Optional;

public class AdminDatabaseGateway implements AdminGateway {

    private final AdminRepository adminRepository;

    public AdminDatabaseGateway(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin create(Admin admin) {
        return this.adminRepository.save(new AdminSchema(admin)).toAdmin();
    }

    @Override
    public Admin update(Admin admin) {
        return this.adminRepository.save(new AdminSchema(admin)).toAdmin();
    }

    @Override
    public void delete(Long id) {
        this.adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> findById(Long id) {
        return adminRepository
                .findById(id)
                .map(AdminSchema::toAdmin);
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository
                .findAll()
                .stream()
                .map(AdminSchema::toAdmin)
                .toList();
    }
}
