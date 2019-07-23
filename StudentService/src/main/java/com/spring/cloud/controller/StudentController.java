package com.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.entity.Student;
import com.spring.cloud.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studenService;
	
	@PostMapping("/post/student")
	public Student postStudent(@RequestBody Student student) {
		return studenService.saveStudent(student);
	}
	
	@GetMapping("/get/students")
	public List<Student> getStudents(){
		return studenService.getStudents();
	}
	
	@GetMapping("get/student/{studentId}")
	public Student getStudent(@PathVariable(name = "studentId") int studentId) {
		return studenService.getStudent(studentId);
	}
	
	public void deleteStudent(int studentId) {
		studenService.deleteStudent(studentId);
	}

}
