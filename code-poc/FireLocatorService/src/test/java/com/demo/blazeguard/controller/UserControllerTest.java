package com.demo.blazeguard.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.blazeguard.config.TestUtils;
import com.demo.blazeguard.model.User;
import com.demo.blazeguard.request.CreateUserRequest;
import com.demo.blazeguard.service.abstractions.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(Parameterized.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {
	
	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();
	
	@MockBean
	private IUserService userService;


	@Autowired
	private MockMvc mockMvc;
	
	private CreateUserRequest request;
	
	public UserControllerTest(CreateUserRequest request) {
		this.request = request;
	}
	
	@Parameters
	public static List<CreateUserRequest> data() {
		CreateUserRequest request1 = new CreateUserRequest();
		CreateUserRequest request2 = new CreateUserRequest();
		request2.setUsername("");
		CreateUserRequest request3 = new CreateUserRequest();
		request3.setUsername("Mert");
		CreateUserRequest request4 = new CreateUserRequest();
		request4.setUsername("Mert");
		request4.setPassword("");
		CreateUserRequest request5 = new CreateUserRequest();
		request5.setUsername("Mert");
		request5.setPassword("mert123");
		CreateUserRequest request6 = new CreateUserRequest();
		request6.setUsername("Mert");
		request6.setPassword("mert123");
		CreateUserRequest request7 = new CreateUserRequest();
		request7.setUsername("Mert");
		request7.setPassword("mert123");
		CreateUserRequest request8 = new CreateUserRequest();
		request8.setUsername("Mert");
		request8.setPassword("mert123");
		CreateUserRequest request9 = new CreateUserRequest();
		request9.setUsername("Mert");
		request9.setPassword("mert123");
		CreateUserRequest request10 = new CreateUserRequest();
		request10.setUsername("exist");
		request10.setPassword("mert123");
			CreateUserRequest request11 = new CreateUserRequest();
		request11.setUsername("Mert");
		request11.setPassword("mert123");
			CreateUserRequest request12 = new CreateUserRequest();
		request12.setUsername("Mert");
		request12.setPassword("mert123");

		List<CreateUserRequest> testCases = new ArrayList<>();
		testCases.add(request1);
		testCases.add(request2);
		testCases.add(request3);
		testCases.add(request4);
		testCases.add(request5);
		testCases.add(request6);
		testCases.add(request7);
		testCases.add(request8);
		testCases.add(request9);
		testCases.add(request10);
		testCases.add(request11);
		testCases.add(request12);
		
		return testCases;
	}
	
	@Test
	public void createUser() throws Exception {
		
		boolean shouldThrowBadRequest = request.getUsername() == null || request.getUsername().isEmpty() || request.getPassword() == null || request.getPassword().isEmpty();
		boolean shouldThrowBadCredentials = false;
		
//		if (request.getUsername() != null && request.getUsername().equals("exist")) {
//			Mockito.when(userService.isUsernameExist(Mockito.anyString())).thenReturn(Boolean.TRUE);
//			shouldThrowBadCredentials = true;
//		}
		
		User mockedUser = new User("Mert6", "12356");
		Mockito.when(userService.createNewUser(Mockito.any())).thenReturn(mockedUser);
		
		String requestAsJson = new ObjectMapper().writeValueAsString(request);
		RequestBuilder requestBuilder = TestUtils.getPostRequestBuilder("/user/create", requestAsJson);
		
		ResultActions resultActions = mockMvc.perform(requestBuilder);
		if(shouldThrowBadRequest) {
			resultActions.andExpect(MockMvcResultMatchers.status().isBadRequest());
		} else if (shouldThrowBadCredentials) {
			resultActions.andExpect(MockMvcResultMatchers.status().isUnauthorized());
		} else {
			resultActions.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.username", equalTo(mockedUser.getUsername())));
		}
	}
	
	@Test
	public void findAll() throws Exception {
		
		List<User> userList = new ArrayList<>();
		User mockedUser = new User("Mert", "mert123");
		userList.add(mockedUser);
		
		Mockito.when(userService.findAll()).thenReturn(userList);
		
		RequestBuilder requestBuilder = TestUtils.getGetRequestBuilder("/user/find/all");
		mockMvc.perform(requestBuilder)
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(jsonPath("$.userList", hasSize(1)))
			.andExpect(jsonPath("$.userList.[0].username", equalTo(mockedUser.getUsername())));
		
	}

}
