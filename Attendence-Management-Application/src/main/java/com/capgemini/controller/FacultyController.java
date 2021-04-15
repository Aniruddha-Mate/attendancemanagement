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

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.entity.FacultyEntity;
import com.capgemini.service.FacultyService;

@RestController
@RequestMapping("/Faculty")
public class FacultyController {
	
	@Autowired
	FacultyService faclServices;
	
	@PostMapping(path="/addFaculty")
	public ResponseEntity<FacultyEntity> addFaculty(@Valid @RequestBody FacultyEntity se)
	{
		FacultyEntity se1 = faclServices.addFaculty(se);
		
		return new ResponseEntity<FacultyEntity>(se1,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteFaculty")
	public ResponseEntity<String> deleteFaculty(@Valid @RequestBody FacultyEntity se)
	{
		faclServices.deleteFaculty(se);
		ResponseEntity re = new ResponseEntity<String>("Deleted from Database", HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getFacultyById/{facultyId}")
	public ResponseEntity<FacultyEntity> getFacultyById(@Valid @PathVariable int facultyId)
	{
		FacultyEntity fe = faclServices.getFacultyById(facultyId);
		ResponseEntity re = new ResponseEntity<FacultyEntity>(fe, HttpStatus.OK);
		return re;
	}
	@DeleteMapping(path="/deleteFacultyById/{facultyId}")
	public ResponseEntity<String> deleteFacultyById(@Valid @PathVariable int facultyId)
	{
		faclServices.deleteFacultyById(facultyId);
		ResponseEntity re = new ResponseEntity<String>("Deleted by Id from Database", HttpStatus.OK);
		return re;
	}
	@GetMapping(path="/getAllFaculties")
	public ResponseEntity<List<FacultyEntity>> getAllFaculty()
	{
		
		List<FacultyEntity> fe = faclServices.getAllFaculty();
		ResponseEntity re = new ResponseEntity<List<FacultyEntity>>(fe, HttpStatus.OK);
		return re;
		
	}
	@PutMapping(path="/updateFacultyById/{facultyId}")
	public ResponseEntity<FacultyEntity> updateFacultyById(@Valid @PathVariable int facultyId, @Valid @RequestBody FacultyEntity se)
	{
		FacultyEntity fe = faclServices.updateFacultyById(facultyId, se);
		ResponseEntity re = new ResponseEntity<FacultyEntity>(fe, HttpStatus.OK);
		return re;
	}
}
