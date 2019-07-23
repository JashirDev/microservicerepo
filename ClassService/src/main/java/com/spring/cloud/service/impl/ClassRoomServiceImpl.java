package com.spring.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cloud.dao.ClassRoomDao;
import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.service.ClassRoomService;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{

	@Autowired
	private ClassRoomDao classRoomDao;
	
	@Override
	public ClassRoom saveClass(ClassRoom classRoom) {
		// TODO Auto-generated method stub
		return classRoomDao.save(classRoom);
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
