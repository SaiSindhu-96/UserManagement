package com.learn.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.usermanagement.model.User;
import com.learn.usermanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	// ✅ EXISTING METHOD
	@Override
	public User save(User user) {
		return repository.save(user);
	}

	// ✅ ADD: GET ALL
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	// ✅ ADD: UPDATE
	@Override
	public User update(Long id, User user) {
		User existingUser = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id " + id));

		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setSalary(user.getSalary());

		return repository.save(existingUser);
	}

	// ✅ ADD: DELETE
	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
