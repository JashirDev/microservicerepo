package com.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.entity.Student;
import com.spring.cloud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studenService;
	
	@PostMapping
	public Student postStudent(@RequestBody Student student) {
		return studenService.saveStudent(student);
	}
	
	@GetMapping
	public List<Student> getStudents(){
		return studenService.getStudents();
	}
	
	@GetMapping("/{studentId}")
	public Student getStudent(@PathVariable(name = "studentId") int studentId) {
		return studenService.getStudent(studentId);
	}
	
	@DeleteMapping("/{studentId}")
	public void deleteStudent(@PathVariable(name = "studentId") int studentId) {
		studenService.deleteStudent(studentId);
	}

}
