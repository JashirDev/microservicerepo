package com.spring.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cloud.dao.ClassRoomDao;
import com.spring.cloud.dao.ClassStudentRoomDao;
import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.entity.ClassStudent;
import com.spring.cloud.feign.ClassStudentClient;
import com.spring.cloud.feign.Student;
import com.spring.cloud.feign.service.FeignService;
import com.spring.cloud.service.ClassRoomService;
import com.spring.cloud.service.ClassStudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService, ClassStudentService{

	private ClassRoomDao classRoomDao;

	private ClassStudentRoomDao classStudentRoomDao;
	private FeignService feignService;

	@Override
	public ClassRoom saveClass(ClassRoom classRoom) {
	
		// TODO Auto-generated method stub
		ClassRoom room = classRoomDao.save(classRoom);//save in the data base
		
		
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
		classRoomDao.deleteById(classID);
		
	}

	@Override
	public ClassStudentClient getClassStudent(int classId) {
		// TODO Auto-generated method stub
		ClassRoom roomclient = classRoomDao.findById(classId).get();
		
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
		client.setClasRoom(roomclient);
		client.setStudent(classStudentList);
		
		
		
		return client;
	}
	
}
