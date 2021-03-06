package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;

public interface SubjectService {
	
	public SubjectEntity addSubject(SubjectEntity entity) throws DuplicateRecordException;
	
	SubjectEntity getSubjectById(int subjectId) throws SubjectNotFoundException;

	SubjectEntity updateSubjectById(int subjectId, SubjectEntity fe) throws SubjectNotFoundException;

	List<SubjectEntity> getAllSubjects();

	String deleteSubById(int subjectId) throws RecordNotFoundException;

	SubjectEntity findSubjectByName(String subjectName);

}