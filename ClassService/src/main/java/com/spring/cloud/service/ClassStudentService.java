package com.spring.cloud.service;

import com.spring.cloud.feign.ClassStudentClient;

public interface ClassStudentService {

	ClassStudentClient getClassStudent(int classId);
}
