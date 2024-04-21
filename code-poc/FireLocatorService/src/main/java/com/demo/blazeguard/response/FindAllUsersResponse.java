package com.demo.blazeguard.response;

import java.util.List;

import com.demo.blazeguard.model.User;

import lombok.Data;

@Data
public class FindAllUsersResponse {
	List<User> userList;
}
