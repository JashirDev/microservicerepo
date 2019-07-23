package com.spring.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cloud.dao.ClassRoomDao;
import com.spring.cloud.dao.ClassStudentRoomDao;
import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.entity.ClassStudent;
import com.spring.cloud.service.ClassRoomService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService{

	private ClassRoomDao classRoomDao;

	private ClassStudentRoomDao classStudentRoomDao;

	@Override
	public ClassRoom saveClass(ClassRoom classRoom) {
	
		// TODO Auto-generated method stub
		ClassRoom room = classRoomDao.save(classRoom);
		
		
		classRoom.getStudentRefrence()
		    .forEach(classStudent -> classStudent.setClassRoomReference(classRoom));
			
		classStudentRoomDao.saveAll(classRoom.getStudentRefrence());
		return room;
	}

	@Override
	public List<ClassRoom> getClassRooms() {
		// TODO Auto-generated method stub
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
	
}
