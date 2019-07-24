package com.spring.cloud.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.cloud.feign.Student;

@FeignClient("student-service")
public interface FeignService {

	@GetMapping("/students")
	List<Student> getStudents();
	
}
