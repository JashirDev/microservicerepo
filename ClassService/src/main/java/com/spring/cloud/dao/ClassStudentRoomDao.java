package com.spring.cloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.spring.cloud.entity.ClassStudent;

@Repository
public interface ClassStudentRoomDao extends JpaRepository<ClassStudent, Integer> {
	
	@Query(value = "SELECT u.student_id FROM class_student u WHERE u.class_id = ?1",nativeQuery = true)
	public List<Integer> getIds(int classId);

}
