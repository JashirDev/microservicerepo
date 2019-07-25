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
import javax.validation.constraints.NotNull;

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
	
	@NotNull(message = "Ingrese datos")
	@Column(name="class_code")
	private int classCode;
	
	@NotNull(message = "Ingrese datos")
	@Column(name="class_name")
	private String className;
	
	
	
	//relation
	@NotNull(message = "Ingrese datos")
	@OneToMany(mappedBy = "classRoomReference",fetch = FetchType.LAZY)
	@JsonIgnoreProperties("classRoomReference")
	private List<ClassStudent> studentRefrence;

}
