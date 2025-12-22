package com.learn.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
