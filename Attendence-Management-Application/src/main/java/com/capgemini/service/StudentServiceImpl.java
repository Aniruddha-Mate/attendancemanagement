package com.capgemini.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.StudentEntity;
import com.capgemini.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository std;

	@Override
	public StudentEntity getStudentById(int studentId) {
		// TODO Auto-generated method stub
		StudentEntity entity=std.findById(studentId).orElse(null);
		return entity;
	}

	@Override
	public List<StudentEntity> getStudents() {
		// TODO Auto-generated method stub
		return std.findAll();
	}

	@Override
	public StudentEntity addStudent(StudentEntity entity) {
		// TODO Auto-generated method stub
		return std.save(entity);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity entity) {
		// TODO Auto-generated method stub
		int Id=entity.getId();
	
		StudentEntity se = std.findById(Id).orElse(null);
		se.setFirstName(entity.getFirstName());
		se.setLastName(entity.getLastName());
		se.setDateOfBirth(entity.getDateOfBirth());
		se.setEmailId(entity.getEmailId());
		se.setFatherEmailId(entity.getFatherEmailId());
		se.setFatherMobileNumber(entity.getFatherMobileNumber());
		se.setGender(entity.getGender());
		se.setMobileNumber(entity.getMobileNumber());
		se.setSemester(entity.getSemester());
		se.setSubjectId(entity.getSubjectId());
		se.setSubjectName(entity.getSubjectName());
		
		return std.save(se);
	}

	
	@Override
	public String deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		StudentEntity st=std.findById(studentId).orElse(null);
		std.delete(st); 
		return "deleted successfully";
	}

	@Override
	public String deleteRecord(StudentEntity e) {
		// TODO Auto-generated method stub
		std.deleteAll();
		return "deleted successfully";
	}

}
