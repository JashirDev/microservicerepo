package com.spring.cloud.service;

import java.util.List;

import com.spring.cloud.entity.ClassRoom;

public interface ClassRoomService {
	
	
	public ClassRoom saveClass(ClassRoom classRoom);
	public List<ClassRoom> getClassRooms();
	public ClassRoom getClassRoom(ClassRoom classRoom);
	void deleteClassRoom(ClassRoom classRoom);
}
