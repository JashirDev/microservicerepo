package com.spring.cloud.service;

import java.util.List;

import com.spring.cloud.entity.Student;


public interface StudentService {
	
	 Student saveStudent(Student student);
	 List<Student> getStudents();
	 Student getStudent(int studentId);
	void deleteStudent(int studentsId);

}
