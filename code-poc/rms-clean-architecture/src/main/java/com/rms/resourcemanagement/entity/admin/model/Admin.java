package com.rms.resourcemanagement.entity.admin.model;


import com.rms.resourcemanagement.entity.user.model.User;

public class Admin extends User {
  public Admin() {
    this.role = "ROLE_ADMIN";
  }

public Admin(String username, String password, String name, String email) {
    super(username, password, name, email);
    this.role = "ROLE_ADMIN";
  }
}
