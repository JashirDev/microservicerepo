package com.spring.cloud.service;

import java.util.List;

import com.spring.cloud.entity.Student;


public interface StudentService {
	
	public Student saveStudent(Student student);
	public List<Student> getStudents();
	public Student getStudent(int studentId);
	void deleteStudent(int studentsId);

}
