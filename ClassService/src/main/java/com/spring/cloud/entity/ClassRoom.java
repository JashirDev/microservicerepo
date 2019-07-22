package com.spring.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "class")
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="class_id")
	private int classId;
	
	@Column(name="class_code")
	private int classCode;
	
	@Column(name="class_name")
	private String className;
	
	@Column(name="student_reference")
	private Student studentReference;

}
