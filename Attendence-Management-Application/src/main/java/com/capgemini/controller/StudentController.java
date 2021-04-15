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

import com.capgemini.entity.StudentEntity;
import com.capgemini.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	StudentService studServices;
	
	@GetMapping("/getStudents")
	public ResponseEntity<List<StudentEntity>> getStudents()
	{
		List<StudentEntity> le=studServices.getStudents();
		ResponseEntity<List<StudentEntity>> re=new ResponseEntity<List<StudentEntity>>(le,HttpStatus.OK);
		return re;
				
	}
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentEntity> getStudent(@PathVariable String id)
	{
		StudentEntity se = studServices.getStudent(Long.parseLong(id));
		ResponseEntity<StudentEntity> re = new ResponseEntity<StudentEntity>(se,HttpStatus.OK);
		return re;
		
	}
	@PostMapping(path="/addStudent")
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity se)
	{
		StudentEntity se1 = studServices.addStudent(se);
		
		return new ResponseEntity<StudentEntity>(se1,HttpStatus.OK);
	}

	@PutMapping(path="/updateStudent")
	public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity se)
	{
		StudentEntity se2 = studServices.updateStudent(se);
		
		return new ResponseEntity<StudentEntity>(se2,HttpStatus.OK);
	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<StudentEntity> updateStudentById(@PathVariable int id)
	{
		StudentEntity se=studServices.updateStudentById(id);
		ResponseEntity<StudentEntity> re = new ResponseEntity<StudentEntity>(se,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteStudent")
	public String deleteStudent(@RequestBody StudentEntity se)
	{
		String s1 = studServices.deleteStudent(se);
		
		return s1;
	}
	@DeleteMapping(path="/deleteStudent/{id}")
	public ResponseEntity<String> deleteRecordById(@PathVariable int id)
	{
		studServices.deleteRecordById(id);
		
		ResponseEntity<String> re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/byfirstname/{firstName}")
	public ResponseEntity<List<StudentEntity>> getAllStudentByFirstName(@PathVariable String firstName)
	{
		return new ResponseEntity<List<StudentEntity>>(studServices.getAllStudentByFirstName(firstName),HttpStatus.OK);
	}
}
