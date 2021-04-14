package com.capgemini.controller;

import java.util.List;

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
	public ResponseEntity<SubjectEntity> addSubject(@RequestBody SubjectEntity se)
	{
		SubjectEntity se1 = subServices.addSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.OK);
	}

	@PutMapping(path="/updateSubject")
	public ResponseEntity<SubjectEntity> updateSubject(@RequestBody SubjectEntity se)
	{
		SubjectEntity se2 = subServices.updateSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se2,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteSubject")
	public String deleteSubject(@RequestBody SubjectEntity se)
	{
		String s1 = subServices.deleteSubject(se);
		
		return s1;
	}
	@PutMapping(path="/updateSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@PathVariable int subjectId, @RequestBody SubjectEntity fe)
	{
		SubjectEntity se = subServices.updateSubjectById(subjectId, fe);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectById(@PathVariable int subjectId)
	{
		SubjectEntity se = subServices.getSubjectById(subjectId);
		ResponseEntity re = new ResponseEntity<SubjectEntity>(se, HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getAllSubjects")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects()
	{
		
		List<SubjectEntity> se = subServices.getAllSubjects();
		ResponseEntity re = new ResponseEntity<List<SubjectEntity>>(se, HttpStatus.OK);
		return re;
		
	}
	@DeleteMapping(path="/deleteSubject/{id}")
	public ResponseEntity<String> deleteSubById(@PathVariable int subjectId)
	{
		subServices.deleteSubById(subjectId);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
}
