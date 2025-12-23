package com.learn.usermanagement.service;

import java.util.List;

import com.learn.usermanagement.model.User;

public interface UserService {
	User save(User user);

	List<User> getAll();

	User update(Long id, User user);

	void delete(Long id);
}