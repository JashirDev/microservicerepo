package com.spring.cloud.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.cloud.entity.ClassRoom;

@Repository
public interface ClassRoomDao extends JpaRepository<ClassRoom, Integer> {
	
	@Query(value = "SELECT u.class_id , u.class_code , u.class_name FROM class u WHERE u.class_id = ?1",nativeQuery = true)
	public ClassRoom getClassById(int classId);

}
