package com.rms.resourcemanagement.infrastructure.config.db.schema;

import com.rms.resourcemanagement.entity.admin.model.Admin;
import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class AdminSchema extends UserSchema {

  public AdminSchema() {
    this.role = "ROLE_ADMIN";
  }

  public AdminSchema(Admin admin) {
    super(admin.getId(), admin.getUsername(), admin.getName(), admin.getEmail(), admin.getPassword());

    this.role = "ROLE_ADMIN";
  }

  public Admin toAdmin() {
    Admin admin = new Admin (
            this.getUsername(),
            this.getPassword(),
            this.getName(),
            this.getEmail()
    );

    admin.setId(this.getId()); // transform the schema id (generated by database) to entity customer id

    return admin;
  }
}
