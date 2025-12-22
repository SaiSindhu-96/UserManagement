package com.learn.usermanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.usermanagement.model.ActivityLog;
import com.learn.usermanagement.repository.ActivityLogRepository;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

	@Autowired
	private ActivityLogRepository repository;

	@Override
	public ActivityLog save(ActivityLog log) {
		log.setTimestamp(LocalDateTime.now());
		return repository.save(log);
	}

	@Override
	public List<ActivityLog> getAll() {
		return repository.findAll();
	}
}
