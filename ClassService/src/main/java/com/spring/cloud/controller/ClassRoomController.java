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

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.feign.ClassStudentClient;
import com.spring.cloud.service.ClassFallbackService;
import com.spring.cloud.service.ClassRoomService;
import com.spring.cloud.service.ClassStudentService;

@RequestMapping("/classes")
@RestController
public class ClassRoomController {
	
	@Autowired
	private ClassRoomService classRoomService;
	
	@Autowired
	private ClassStudentService classStudentService;
	
	@Autowired
	private ClassFallbackService classFallbackService;
	
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
	@HystrixCommand(fallbackMethod = "getClassAndStudentFallback", 
										commandProperties = {
												//timeout for the request, in other word wait for this long
												@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
												@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
												//if the 50% of teh request fail the circuit is going to break
												@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
												//how long the cricuit breaker is going to wait to call again to the service
												@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
										})
	public ClassStudentClient getClassAndStudents(@PathVariable(name ="classId" )  int classId) {
		
		return classStudentService.getClassStudent(classId);
	}
	
	
	//DELETE METHODS
	
	@DeleteMapping("/{classId}")
	public void deletClassRoom(@PathVariable(name ="classId" ) int classId) {
		classRoomService.deleteClassRoom(classId);
	}
	
	

	

	//FALBACK TO CLASS WITH STUDENT
	
	public ClassStudentClient getClassAndStudentFallback ( int classId) {
		
		return classFallbackService.getclassAndStudentFallback();
	}

}
