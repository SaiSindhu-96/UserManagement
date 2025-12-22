package com.learn.usermanagement.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.usermanagement.model.User;
import com.learn.usermanagement.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateUser() throws Exception {
		User user = new User();
		user.setId(1L);
		user.setName("Sindhu");
		user.setEmail("s@gmail.com");
		user.setSalary(45000);

		when(userService.save(any(User.class))).thenReturn(user);

		mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user))).andExpect(status().isOk());
	}

	@Test
	void testGetAllUsers() throws Exception {
		when(userService.getAll()).thenReturn(Arrays.asList(new User(1L, "Sindhu", "s@gmail.com", 45000)));

		mockMvc.perform(get("/api/users")).andExpect(status().isOk());
	}
}
