package com.demo.blazeguard.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreateUserRequest extends BaseRequest {

	private String username;
	private String password;
}
