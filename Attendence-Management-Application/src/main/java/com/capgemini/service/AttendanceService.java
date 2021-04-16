package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.exception.AttendanceIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;

public interface AttendanceService {
	
	//For adding the attendance one by one
	public AttendanceEntity addAttendance(AttendanceEntity entity);
	
	//For Getting the details of all the attendance present in the database
	public List<AttendanceEntity> getAttendance() throws RecordNotFoundException;
	
	//For Getting the details of the attendance by Attendance ID
	public AttendanceEntity getAttendanceById(int attendanceId) throws AttendanceIdNotFoundException;
	
	//For Updating the details of the Attendance By Attendance ID
	public AttendanceEntity updateAttendanceById(int attendanceId,AttendanceEntity entity)throws AttendanceIdNotFoundException;
	
	//For deleting records of Attendance by Attendance ID
	public String deleteById(int attendanceId) throws RecordNotFoundException;
	}

