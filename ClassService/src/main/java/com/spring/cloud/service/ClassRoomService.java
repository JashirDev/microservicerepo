package com.spring.cloud.service;

import java.util.List;

import com.spring.cloud.entity.ClassRoom;

public interface ClassRoomService {
	
	ClassRoom saveClass(ClassRoom classRoom);
	List<ClassRoom> getClassRooms();
	ClassRoom getClassRoom(int classRoom);
	void deleteClassRoom(int classRoom);
}
