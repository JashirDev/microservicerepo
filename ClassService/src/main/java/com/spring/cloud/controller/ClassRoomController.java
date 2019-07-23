package com.spring.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.service.ClassRoomService;

@RestController
public class ClassRoomController {
	
	@Autowired
	private ClassRoomService classRoomService;
	
	//POST METHODS
	@PostMapping("/post/class")
	public ClassRoom postClassRooom(@RequestBody ClassRoom classRoom) {
		return classRoomService.saveClass(classRoom);
	}
	
	//Get METHODS
	
	@GetMapping("/get/classes")
	public List<ClassRoom> getClasses() {
		return classRoomService.getClassRooms();
	}
	
	@GetMapping("/get/class/{classId}")
	public ClassRoom getClassRooom(@PathVariable(name ="classId" ) int classId) {
		return classRoomService.getClassRoom(classId);
	}
	@GetMapping("/get/classes/{classId}")
	public void deletClassRoom(@PathVariable(name ="classId" ) int classId) {
		classRoomService.deleteClassRoom(classId);
	}

}
