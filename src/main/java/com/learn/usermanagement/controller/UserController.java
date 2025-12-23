package com.learn.usermanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.usermanagement.model.User;
import com.learn.usermanagement.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// ✅ Existing POST (UNCHANGED)
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.save(user);
	}

	// ✅ Existing GET (UNCHANGED)
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	// ✅ ADD: PUT - update user by id
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.update(id, user);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return "User deleted successfully";
	}

}
