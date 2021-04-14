package com.capgemini.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.entity.AttendanceEntity;

public interface AttendanceService {
	
	public AttendanceEntity addAttendance(AttendanceEntity entity);
	
	public AttendanceEntity updateAttendance(AttendanceEntity entity);
	
	public String deleteAttendance(AttendanceEntity entity);
	
	public AttendanceEntity getAttendanceById(int attendanceId);
	
}

