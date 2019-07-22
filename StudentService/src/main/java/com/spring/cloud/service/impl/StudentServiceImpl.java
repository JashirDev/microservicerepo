package com.spring.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cloud.dao.StudentDao;
import com.spring.cloud.entity.Student;
import com.spring.cloud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.findById(studentId).get();
	}

	@Override
	public void deleteStudent(int studentsId) {
		studentDao.deleteById(studentsId);
		
	}
	
	

}
