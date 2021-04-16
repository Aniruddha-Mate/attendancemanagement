package com.capgemini.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.entity.AttendanceEntity;

public interface AttendanceService {
	
	public AttendanceEntity addAttendance(AttendanceEntity entity);
	
	public AttendanceEntity getAttendanceById(int attendanceId);

	public AttendanceEntity updateAttendanceById(int attendanceId, AttendanceEntity entity);

	public List<AttendanceEntity> getAttendance();

	public String deleteById(int attendanceId);
	
}

