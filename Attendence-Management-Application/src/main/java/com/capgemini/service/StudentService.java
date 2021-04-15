package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.StudentEntity;

public interface StudentService {

	public StudentEntity getStudentById(int studentId);

	public List<StudentEntity> getStudents();
	
	public StudentEntity addStudent(StudentEntity entity);

	public StudentEntity updateStudent(StudentEntity entity);

	public String deleteStudent(int studentId);

	public String deleteRecord(StudentEntity e);
	
	

}
