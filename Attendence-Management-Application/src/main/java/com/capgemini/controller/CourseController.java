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
		
		return new ResponseEntity<CourseEntity>(se1,HttpStatus.OK);
	}

		
	@PutMapping(path="/updateCourse/{courseId}")
	public ResponseEntity<CourseEntity> updateByCourseId(@Valid @PathVariable int courseId, @Valid @RequestBody CourseEntity entity)
	{
		return new ResponseEntity<CourseEntity>(courServices.updateByCourseId(courseId,entity),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteByCourseId/{courseId}")
	public String deleteByCourseId(@Valid @PathVariable int courseId)
	{
	
		courServices.deleteByCourseId(courseId);
	    return "Deleted By Course Id";
	}
	
	@GetMapping(path="/getAllCourse")
	public ResponseEntity<List<CourseEntity>> getCourse()
	{
		return new ResponseEntity<List<CourseEntity>>(courServices.getCourse(),HttpStatus.OK);
	}
	
	@GetMapping(path="/getByCourseId/{courseId}")
	public ResponseEntity<CourseEntity> getCourseById(@Valid @PathVariable int courseId)
	{
		return new ResponseEntity<CourseEntity>(courServices.getCourseById(courseId),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteAllCourse")
	public String deleteAllCourse()
	{
		courServices.deleteAllCourse();
		return "Deleted All The Data";
	}
}
