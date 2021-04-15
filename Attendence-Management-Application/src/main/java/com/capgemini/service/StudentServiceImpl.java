package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.StudentEntity;
import com.capgemini.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository srepo;

	@Override
	public StudentEntity addStudent(StudentEntity entity) {
		
		StudentEntity se = (StudentEntity) srepo.save(entity);
		return se;
	}

	@Override
	public StudentEntity updateStudent(StudentEntity entity) {
		
		int id = entity.getRollNo();
		StudentEntity se = (StudentEntity) srepo.findById(id).orElse(null);
		se.setFirstName(entity.getFirstName());
		se.setLastName(entity.getLastName());
		se.setDateOfBirth(entity.getDateOfBirth());
		se.setEmailId(entity.getEmailId());
		se.setFatherEmailId(entity.getFatherEmailId());
		se.setFatherMobileNumber(entity.getFatherMobileNumber());
		se.setGender(entity.getGender());
		se.setMobileNumber(entity.getMobileNumber());
		se.setSemester(entity.getSemester());
		srepo.save(se);
		
		return se;
	}

	@Override
	public String deleteStudent(StudentEntity entity) {
		srepo.delete(entity);
		return "Deleted";
	}

	@Override
	public List<StudentEntity> getAllStudentByFirstName(String firstName) {
		return srepo.findAllByFirstName(firstName);
	}

	@Override
	public List<StudentEntity> getStudents() {
		// TODO Auto-generated method stub
		
		return srepo.findAll();
	}

	@Override
	public StudentEntity getStudent(long parseLong) {
		// TODO Auto-generated method stub
		return srepo.getOne((int) parseLong);
	}

	@Override
	public StudentEntity updateStudentById(int id) {
		// TODO Auto-generated method stub
		StudentEntity se = srepo.findById(id).orElse(null);  	
		se.setFirstName(se.getFirstName());
		se.setLastName(se.getLastName());
		srepo.save(se);
		return se;
	}

	@Override
	public String deleteRecordById(int id) {
		// TODO Auto-generated method stub
		srepo.findById(id).orElse(null);
		srepo.deleteById(id);
		return "Deleted";
	}

}
