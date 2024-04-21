package com.rms.resourcemanagement.infrastructure.config.db.repository;

import com.rms.resourcemanagement.infrastructure.config.db.schema.AdminSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminSchema, Long> {

}
