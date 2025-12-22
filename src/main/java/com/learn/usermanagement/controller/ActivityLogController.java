package com.learn.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.usermanagement.model.ActivityLog;
import com.learn.usermanagement.service.ActivityLogService;

@RestController
@RequestMapping("/logs")
public class ActivityLogController {

	@Autowired
	private ActivityLogService service;

	@PostMapping
	public ActivityLog createLog(@RequestBody ActivityLog log) {
		return service.save(log);
	}

	@GetMapping
	public List<ActivityLog> getAllLogs() {
		return service.getAll();
	}
}
