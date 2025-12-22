package com.learn.usermanagement.service;

import java.util.List;

import com.learn.usermanagement.model.User;

public interface UserService {
	User save(User user);

	List<User> getAll();
}