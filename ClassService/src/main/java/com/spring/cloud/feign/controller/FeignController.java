package com.spring.cloud.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.feign.Student;
import com.spring.cloud.feign.service.FeignService;

@RestController
public class FeignController {
	
	
	@Autowired
	private FeignService feignService;
	
	@GetMapping("/feign-clases")
	public List<Student> getStdeunts() {
		return feignService.getStudents();
	}

}
