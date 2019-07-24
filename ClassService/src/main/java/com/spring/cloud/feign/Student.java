package com.spring.cloud.feign;

import java.sql.Date;
import lombok.Data;

@Data
public class Student {
	

	private int studenstId; 
	
	private String gender;
	
	private String firstName;
	

	private String MiddleName;
	
	private String lastName;
	
	
	private String otherStudentDeteails;
	
	
	private Date dateOfBirth;

}
