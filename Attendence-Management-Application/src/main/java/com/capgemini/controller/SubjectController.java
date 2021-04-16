package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.service.SubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
	
	@Autowired
	SubjectService subServices;
	
	@PostMapping(path="/addSubject")
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity se) throws DuplicateRecordException
	{
		SubjectEntity se1 = subServices.addSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/updateSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@Valid @PathVariable int subjectId, @Valid @RequestBody SubjectEntity fe) throws SubjectNotFoundException
	{
		SubjectEntity se = subServices.updateSubjectById(subjectId, fe);
		return new ResponseEntity<SubjectEntity>(se, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(path="/getSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectById(@Valid @PathVariable int subjectId) throws SubjectNotFoundException
	{
		SubjectEntity se = subServices.getSubjectById(subjectId);
		return new ResponseEntity<SubjectEntity>(se, HttpStatus.FOUND);
		
	}
	
	@GetMapping(path="/getAllSubjects")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects()
	{
		
		List<SubjectEntity> se = subServices.getAllSubjects();
		return new ResponseEntity<List<SubjectEntity>>(se, HttpStatus.OK);
		
	}
	@DeleteMapping(path="/deleteSubject/{subjectId}")
	public ResponseEntity<String> deleteSubById(@Valid @PathVariable int subjectId) throws RecordNotFoundException
	{
		subServices.deleteSubById(subjectId);
		
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
}
