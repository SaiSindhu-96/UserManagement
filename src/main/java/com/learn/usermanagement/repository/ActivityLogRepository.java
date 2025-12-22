package com.learn.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.learn.usermanagement.model.ActivityLog;

public interface ActivityLogRepository extends MongoRepository<ActivityLog, String> {
}