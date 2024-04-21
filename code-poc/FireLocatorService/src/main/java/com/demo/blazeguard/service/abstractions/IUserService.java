package com.demo.blazeguard.service.abstractions;

import java.util.List;

import com.demo.blazeguard.model.User;

public interface IUserService {

	List<User> findAll();

	User findByUserName(String username);

	User createNewUser(User user);


}
