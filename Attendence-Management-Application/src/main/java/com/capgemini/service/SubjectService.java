package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.SubjectEntity;

public interface SubjectService {
	
	public SubjectEntity addSubject(SubjectEntity entity);
	
	public String deleteSubject(SubjectEntity entity);

	SubjectEntity getSubjectById(int subjectId);

	SubjectEntity updateSubjectById(int subjectId, SubjectEntity fe);

	List<SubjectEntity> getAllSubjects();

	String deleteSubById(int subjectId);

}
