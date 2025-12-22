package com.learn.usermanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learn.usermanagement.model.User;
import com.learn.usermanagement.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	void testGetAllUsers() {
		when(userRepository.findAll()).thenReturn(List.of(new User(1L, "Sindhu", "s@gmail.com", 45000)));

		List<User> users = userService.getAll();
		assertEquals(1, users.size());
	}
}
