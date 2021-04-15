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
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.StudentEntity;
import com.capgemini.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studService;
	
	@GetMapping("/get/{studentId}")
	public ResponseEntity<StudentEntity> getStudentById(@Valid @PathVariable int studentId)
	{
		return new ResponseEntity<StudentEntity>(studService.getStudentById(studentId),HttpStatus.FOUND);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<StudentEntity>> getStudents()
	{
		return new ResponseEntity<List<StudentEntity>>(studService.getStudents(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<StudentEntity> addStudent(@Valid @RequestBody StudentEntity entity)
	{
		return new ResponseEntity<StudentEntity>(studService.addStudent(entity),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StudentEntity> updateStudent(@Valid @RequestBody StudentEntity entity)
	{
		return new ResponseEntity<StudentEntity>(studService.updateStudent(entity),HttpStatus.ACCEPTED);
	}
	

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@Valid @PathVariable int studentId) 
	{
		return new ResponseEntity<String>(studService.deleteStudent(studentId),HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteStudents")
	public ResponseEntity<String> deleteRecord(@Valid @RequestBody StudentEntity s)
	{
		studService.deleteRecord(s);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);

	}


}
