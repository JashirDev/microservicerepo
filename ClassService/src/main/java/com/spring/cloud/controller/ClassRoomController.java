package com.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.feign.ClassStudentClient;
import com.spring.cloud.service.ClassRoomService;
import com.spring.cloud.service.ClassStudentService;

@RequestMapping("/classes")
@RestController
public class ClassRoomController {
	
	@Autowired
	private ClassRoomService classRoomService;
	
	@Autowired
	private ClassStudentService classStudentService;
	
	//POST METHODS
	@PostMapping
	public ClassRoom postClassRooom(@RequestBody ClassRoom classRoom) {
		return classRoomService.saveClass(classRoom);
	}
	
	//GET METHODS
	@GetMapping
	public List<ClassRoom> getClasses() {
		return classRoomService.getClassRooms();
	}
	
	@GetMapping("/{classId}")
	public ClassRoom getClassRooom(@PathVariable(name ="classId" ) int classId) {
		return classRoomService.getClassRoom(classId);
	}
	
	//GET METHOD THAT CONSUMES STUDNET SERVICE
	@GetMapping("/students/{classId}")
	public ClassStudentClient getClassAndStudents(@PathVariable(name ="classId" )  int classId) {
		
		return classStudentService.getClassStudent(classId);
	}
	
	
	//DELETE METHODS
	
	@DeleteMapping("/{classId}")
	public void deletClassRoom(@PathVariable(name ="classId" ) int classId) {
		classRoomService.deleteClassRoom(classId);
	}
	
	

}
