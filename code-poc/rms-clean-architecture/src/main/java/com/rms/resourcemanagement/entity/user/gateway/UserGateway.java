package com.rms.resourcemanagement.entity.user.gateway;

import com.rms.resourcemanagement.entity.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    void create(User user);
    void update(User user);
    void delete(Long id);

    Optional<User> findById(Long id);
    List<User> searchByName(String nameFragment);
}
