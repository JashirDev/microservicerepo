package com.spring.cloud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "class_student")
public class ClassStudent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="class_student_id")
	private int classStudentId;
	
	@Column(name="student_id")
	private int studentId;
	
	//relation

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("studentRefrence")
	@JoinColumn(name = "class_id")
	private ClassRoom classRoomReference;
	

}
