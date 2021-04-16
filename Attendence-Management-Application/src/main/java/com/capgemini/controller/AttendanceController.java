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
import com.capgemini.service.AttendanceService;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attService;
	
	@PostMapping(path="/addAttendance")
	public ResponseEntity<AttendanceEntity> addAttend(@Valid @RequestBody AttendanceEntity ae)
	{
		return new ResponseEntity<AttendanceEntity>(attService.addAttendance(ae),HttpStatus.CREATED);
	}
	
	@PutMapping(path="/updateAttendance/{attendanceId}")
	public ResponseEntity<AttendanceEntity> updateAttendById(@Valid @PathVariable int attendanceId, @Valid @RequestBody AttendanceEntity entity)
	{
		return new ResponseEntity<AttendanceEntity>(attService.updateAttendanceById(attendanceId,entity),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/getAllAttendance")
	public ResponseEntity<List<AttendanceEntity>> getAttendance()
	{
		return new ResponseEntity<List<AttendanceEntity>>(attService.getAttendance(),HttpStatus.OK);
	}
	
	@GetMapping(path="/getAttendanceById/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@Valid @PathVariable int attendanceId)
	{
		AttendanceEntity ae = attService.getAttendanceById(attendanceId);
		return new ResponseEntity<AttendanceEntity>(ae, HttpStatus.FOUND);
		
	}
	
	@DeleteMapping(path="/deleteAttendance/{attendanceId}")
	public String deleteAttendanceById(@Valid @PathVariable int attendanceId)
	{
		return attService.deleteById(attendanceId);
	}
}
