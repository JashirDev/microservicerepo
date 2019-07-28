package com.spring.cloud.service;


import com.spring.cloud.feign.ClassStudentClient;

public interface ClassFallbackService {
	
	
	
	ClassStudentClient getclassAndStudentFallback();

}
