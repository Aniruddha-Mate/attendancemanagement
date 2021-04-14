package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.FacultyEntity;

public interface FacultyService {
	
	public FacultyEntity addFaculty(FacultyEntity entity);
	
	public FacultyEntity updateFaculty(FacultyEntity entity);
	
	public String deleteFaculty(FacultyEntity entity);

	public FacultyEntity getFacultyById(int facultyId);

	public String deleteFacultyById(int facultyId);

	public List<FacultyEntity> getAllFaculty();

	FacultyEntity updateFacultyById(int facultyId, FacultyEntity se);
}
