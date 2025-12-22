package com.learn.usermanagement.service;

import java.util.List;

import com.learn.usermanagement.model.ActivityLog;

public interface ActivityLogService {
	ActivityLog save(ActivityLog log);

	List<ActivityLog> getAll();
}
