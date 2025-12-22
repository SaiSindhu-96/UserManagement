package com.learn.usermanagement.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.learn.usermanagement.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void saveUserRepositoryTest() {
		User user = new User();
		user.setName("Sindhu");
		user.setEmail("s@gmail.com");
		user.setSalary(45000);

		User savedUser = userRepository.save(user);

		assertNotNull(savedUser.getId());
	}
}
