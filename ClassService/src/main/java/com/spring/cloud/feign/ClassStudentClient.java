package com.spring.cloud.feign;

import java.util.List;

import com.spring.cloud.entity.ClassRoom;

import lombok.Data;

@Data
public class ClassStudentClient {

	private ClassRoom clasRoom;
	
	private List<Student> student;
	
	
}
