package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectRepository srepo;

	@Override
	public SubjectEntity addSubject(SubjectEntity entity) {
		
		SubjectEntity se = (SubjectEntity) srepo.save(entity);		
		return se;
	}

	@Override
	public String deleteSubject(SubjectEntity entity) {
		srepo.delete(entity);
		return "Deleted";
	}
	@Override
	public String deleteSubById(int subjectId) {
		SubjectEntity se=srepo.findById(subjectId).orElse(null);
		srepo.deleteById(subjectId);
		return "Deleted";
	}
	@Override
	public SubjectEntity getSubjectById(int subjectId) {
      SubjectEntity se = srepo.findById(subjectId).orElse(null);
		return se;
	}
	@Override
	public List<SubjectEntity> getAllSubjects() {
		List<SubjectEntity> se = new ArrayList<SubjectEntity>();
		se = srepo.findAll();		
		return se;
	}

	@Override
	public SubjectEntity updateSubjectById(int subjectId, SubjectEntity fe) {
		SubjectEntity se = srepo.findById(subjectId).orElse(null);
		se.setSubjectName(fe.getSubjectName());
		se.setSubject_semester(fe.getSubject_semester());
		se.setDescription(fe.getDescription());
		srepo.save(se);
		return se;
	}
	
	

}
