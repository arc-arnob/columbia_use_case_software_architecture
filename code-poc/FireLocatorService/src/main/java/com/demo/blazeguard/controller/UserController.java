package com.demo.blazeguard.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.blazeguard.configuration.Constants;
import com.demo.blazeguard.exception.BadRequestException;
import com.demo.blazeguard.model.User;
import com.demo.blazeguard.request.CreateUserRequest;
import com.demo.blazeguard.response.FindAllUsersResponse;
import com.demo.blazeguard.service.abstractions.IUserService;

@RestController
@RequestMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {

	private IUserService userService;

	@GetMapping("/find/all")
	public FindAllUsersResponse findAll() {
		List<User> userList = userService.findAll();

		FindAllUsersResponse response = new FindAllUsersResponse();
		response.setUserList(userList);
		return response;
	}

	@PostMapping("/create")
	public User createUser(@RequestBody CreateUserRequest request) {

		if (request.getUsername() == null || request.getUsername().isEmpty()) {
			throw new BadRequestException(Constants.MESSAGE_INVALIDUSERNAME);
		}

		if (request.getPassword() == null || request.getPassword().isEmpty()) {
			throw new BadRequestException(Constants.MESSAGE_INVALIDPASSWORD);
		}


        return userService.createNewUser(new User(request.getUsername(), request.getPassword()));
    }


}
