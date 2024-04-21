package com.rms.resource.management.service.spec;

import com.rms.resource.management.domain.Admin;
import com.rms.resource.management.dto.admin.AdminUpdateData;
import com.rms.resource.management.dto.admin.AdminRegistrationData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdminService {

  Admin findById(Long id);

  Page<Admin> findAll(Pageable pageable);

  Admin save(AdminRegistrationData admin);

  Admin delete(Long id);

  Admin update(Long id, AdminUpdateData dados);
}
