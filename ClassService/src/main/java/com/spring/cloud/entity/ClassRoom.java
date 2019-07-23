package com.spring.cloud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	//@Column(name="student_reference")
	//private Student studentReference;
	
	//relation
	
	@OneToMany(mappedBy = "classRoomReference",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("classRoomReference")
	private List<ClassStudent> studentRefrence;

}
