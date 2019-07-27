package com.spring.cloud.service;

import java.util.List;
import com.spring.cloud.entity.Student;

public interface StudentFallbackService {

	Student studentFallback();
	
}
