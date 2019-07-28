package com.spring.cloud.feign;

import java.util.List;
import lombok.Data;

@Data
public class ClassStudentClient {

	private int classId;
		
	private int classCode;
	
	private String className;
	
	private List<Student> student;
	
	
}
