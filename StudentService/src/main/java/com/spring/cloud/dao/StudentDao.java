package com.spring.cloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.cloud.entity.Student;

@Repository
public interface StudentDao  extends JpaRepository<Student, Integer>{

}
