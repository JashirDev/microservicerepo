package com.spring.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.entity.ClassRoom;
import com.spring.cloud.entity.ClassStudent;

@Repository
public interface ClassStudentRoomDao extends JpaRepository<ClassStudent, Integer> {

}
