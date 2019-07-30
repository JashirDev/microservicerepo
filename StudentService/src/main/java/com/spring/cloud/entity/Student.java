package com.spring.cloud.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="students_id")
	private int studenstId; 


	@NotNull(message = "Ingrese datos")
	@Column(name = "gender")
	@Size(min = 1, max = 30)
	private String gender;

	@Size(min = 1, max = 30)

	@NotNull(message = "Ingrese datos")
	@Column(name = "first_name")
	private String firstName;

	@Size(min = 1, max = 30)
	@NotNull(message = "Ingrese datos")
	@Column(name = "middle_name")
	private String middleName;

	@Size(min = 1, max = 30)
	@NotNull(message = "Ingrese datos")
	@Column(name = "last_name")
	private String lastName;

	@Size(min = 1, max = 50)
	@NotNull(message = "Ingrese datos")
	@Column(name = "other_student_deteails")
	private String otherStudentDeteails;

	@NotNull(message = "Ingrese datos")
	@Column(name = "date_of_birth")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date dateOfBirth;

	
}
