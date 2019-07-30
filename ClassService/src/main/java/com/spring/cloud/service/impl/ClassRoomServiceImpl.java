package com.spring.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import com.spring.cloud.dao.ClassRoomDao;
import com.spring.cloud.dao.ClassStudentRoomDao;
import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.entity.ClassStudent;
import com.spring.cloud.feign.ClassStudentClient;
import com.spring.cloud.feign.Student;
import com.spring.cloud.feign.service.FeignService;
import com.spring.cloud.service.ClassFallbackService;
import com.spring.cloud.service.ClassRoomService;
import com.spring.cloud.service.ClassStudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService, ClassStudentService,ClassFallbackService{

	private ClassRoomDao classRoomDao;

	private ClassStudentRoomDao classStudentRoomDao;
	
	private FeignService feignService;

	@Override
	public ClassRoom saveClass(ClassRoom classRoom) {
	
		//SAVE INTO DATABASE
		ClassRoom room = classRoomDao.save(classRoom);
		
		
		classRoom.getStudentRefrence()
		    .forEach(classStudent -> classStudent.setClassRoomReference(classRoom));
			
		classStudentRoomDao.saveAll(classRoom.getStudentRefrence());
		
		
		return room;
		
	}

	@Override
	public List<ClassRoom> getClassRooms() {
		// TODO Auto-generated method stub
		//System.out.print("IDS"+classStudentRoomDao.getIds(1));//funciona
		return classRoomDao.findAll();
	}

	@Override
	public ClassRoom getClassRoom(int classID) {
		// TODO Auto-generated method stub
		return classRoomDao.findById(classID).get();
	}

	@Override
	public void deleteClassRoom(int classID) {
		
		ClassRoom room = classRoomDao.findById(classID).get();
		//DELETE CALSSSTUDENT FROM DATABASE
		room.getStudentRefrence()
	    .forEach(classStudent -> classStudentRoomDao.deleteById(classStudent.getClassStudentId()));
		//DELETE CLASS FROM DATABASE
		classRoomDao.deleteById(classID);
		
		
		
	}

	@Override
	public ClassStudentClient getClassStudent(int classId) {
		// TODO Auto-generated method stub
		
		ClassRoom roomclient = classRoomDao.getClassById(classId);
		//list if students ids
		List<Integer>studentsId = classStudentRoomDao.getIds(classId);
		//list of all student
		List<Student> studentList=feignService.getStudents();
		//list to save students that have been filtered
		List<Student> classStudentList= new ArrayList<>();
		
		//filter of students by classid
		for(int i = 0 ; i<studentList.size();i++) {
			for(int j=0 ; j<studentsId.size();j++) {
				if(studentList.get(i).getStudenstId() == studentsId.get(j)) {
					classStudentList.add(studentList.get(i));
				}
			}
		}
		
	
		
		ClassStudentClient client=new ClassStudentClient();
		client.setClassCode(roomclient.getClassCode());
		client.setClassId(roomclient.getClassId());
		client.setClassName(roomclient.getClassName());
		client.setStudent(classStudentList);
		
		
		
		return client;
	}
	
	
	//FALLBACK TO GET CLASSES WITH STUDENTS
	@Override
	public ClassStudentClient getclassAndStudentFallback() {
		// TODO Auto-generated method stub
		ClassStudentClient classStudentFalback= new ClassStudentClient();
		ClassRoom classFalback = new ClassRoom();
		List<ClassStudent> studentIdFallback =new ArrayList<ClassStudent>();
		
		ClassStudent student= new ClassStudent();
		student.setStudentId(0);
		student.setClassStudentId(0);
		student.setClassRoomReference(classFalback);
		studentIdFallback.add(student);		
		
		classFalback.setClassCode(0);
		classFalback.setClassId(0);
		classFalback.setClassName("class Falback");

		classStudentFalback.setClassCode(classFalback.getClassCode());
		classStudentFalback.setClassId(classFalback.getClassId());
		classStudentFalback.setClassName(classFalback.getClassName());
		classStudentFalback.setStudent(null);
	
		return classStudentFalback;
	}
	
}
