package com.rms.resource.management.repository;

import com.rms.resource.management.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
}
