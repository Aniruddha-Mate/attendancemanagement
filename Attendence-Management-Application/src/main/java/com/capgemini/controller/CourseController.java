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

import com.capgemini.entity.CourseEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.service.CourseService;


@RestController
@RequestMapping("/Course")
public class CourseController {
	
	@Autowired
	CourseService courServices;
	
	@PostMapping(path="/addCourse")
	public ResponseEntity<CourseEntity> addCourse(@Valid @RequestBody CourseEntity se)
	{
		CourseEntity se1 = courServices.addCourse(se);
		
		return new ResponseEntity<CourseEntity>(se1,HttpStatus.CREATED);
	}

		
	@PutMapping(path="/updateCourse/{courseId}")
	public ResponseEntity<CourseEntity> updateByCourseId(@Valid @PathVariable int courseId, @Valid @RequestBody CourseEntity entity) throws CourseIdNotFoundException
	{
		return new ResponseEntity<CourseEntity>(courServices.updateByCourseId(courseId,entity),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/deleteByCourseId/{courseId}")
	public String deleteByCourseId(@Valid @PathVariable int courseId) throws RecordNotFoundException
	{
	
		courServices.deleteByCourseId(courseId);
	    return "Deleted By Course Id";
	}
	
	@GetMapping(path="/getAllCourse")
	public ResponseEntity<List<CourseEntity>> getCourse() throws RecordNotFoundException
	{
		return new ResponseEntity<List<CourseEntity>>(courServices.getCourse(),HttpStatus.FOUND);
	}
	
	@GetMapping(path="/getByCourseId/{courseId}")
	public ResponseEntity<CourseEntity> getCourseById(@Valid @PathVariable int courseId) throws CourseIdNotFoundException 
	{
		return new ResponseEntity<CourseEntity>(courServices.getCourseById(courseId),HttpStatus.FOUND);
	}
	

}
