package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.CourseEntity;

public interface CourseService {
	
    public CourseEntity addCourse(CourseEntity entity);
	
	public String deleteByCourseId(int courseId);
	
	public List<CourseEntity> getCourse();
	
	public CourseEntity getCourseById(int courseId);
	
	public CourseEntity updateByCourseId(int courseid, CourseEntity entity);

}
