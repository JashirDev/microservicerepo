package com.spring.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.entity.ClassRoom;

@Repository
public interface ClassRoomDao extends JpaRepository<ClassRoom, Integer> {

}
