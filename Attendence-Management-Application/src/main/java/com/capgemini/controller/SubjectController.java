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
import com.capgemini.service.SubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
	
	@Autowired
	SubjectService subServices;
	
	@PostMapping(path="/addSubject")
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity se)
	{
		SubjectEntity se1 = subServices.addSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/deleteSubject")
	public String deleteSubject(@Valid @RequestBody SubjectEntity se)
	{
		String s1 = subServices.deleteSubject(se);
		
		return s1;
	}
	@PutMapping(path="/updateSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@Valid @PathVariable int subjectId, @Valid @RequestBody SubjectEntity fe)
	{
		SubjectEntity se = subServices.updateSubjectById(subjectId, fe);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.ACCEPTED);
		return re;
	}
	
	@GetMapping(path="/getSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectById(@Valid @PathVariable int subjectId)
	{
		SubjectEntity se = subServices.getSubjectById(subjectId);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.FOUND);
		return re;
	}
	
	@GetMapping(path="/getAllSubjects")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects()
	{
		
		List<SubjectEntity> se = subServices.getAllSubjects();
		ResponseEntity re = new ResponseEntity<List<SubjectEntity>>(se, HttpStatus.OK);
		return re;
		
	}
	@DeleteMapping(path="/deleteSubject/{subjectId}")
	public ResponseEntity<String> deleteSubById(@Valid @PathVariable int subjectId)
	{
		subServices.deleteSubById(subjectId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
