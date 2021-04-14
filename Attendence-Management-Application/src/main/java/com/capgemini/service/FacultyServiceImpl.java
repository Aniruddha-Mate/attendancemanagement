package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
		
	@Autowired
	FacultyRepository frepo;
	
	@Override
	public FacultyEntity addFaculty(FacultyEntity entity)
	{
		FacultyEntity fe = (FacultyEntity) frepo.save(entity);
		return fe;
	}

	@Override
	public FacultyEntity updateFaculty(FacultyEntity entity) {
		
		int id = entity.getFacultyId();
		FacultyEntity fe1 = (FacultyEntity) frepo.findById(id).orElse(null);
		fe1.setFacultyName(entity.getFacultyName());
		frepo.save(fe1);
		return fe1;
	}

	@Override
	public String deleteFaculty(FacultyEntity entity) {
		frepo.delete(entity);
				
		return "Deleted";
	}

	@Override
	public FacultyEntity getFacultyById(int facultyId) {
		
		FacultyEntity fe = frepo.findById(facultyId).orElse(null);
		
		return fe;
	}

	@Override
	public String deleteFacultyById(int facultyId) {
		
		FacultyEntity fe = frepo.findById(facultyId).orElse(null);
		frepo.deleteById(facultyId);
		return "Deleted by Id";	
	}

	@Override
	public List<FacultyEntity> getAllFaculty() {
		List<FacultyEntity> fe = new ArrayList<FacultyEntity>();
		fe = frepo.findAll();		
		return fe;
	}

	@Override
	public FacultyEntity updateFacultyById(int facultyId, FacultyEntity se) {
		FacultyEntity fe = frepo.findById(facultyId).orElse(null);
		fe.setFacultyName(se.getFacultyName());
		frepo.save(fe);
		return fe;
	}
	
	

    
}

