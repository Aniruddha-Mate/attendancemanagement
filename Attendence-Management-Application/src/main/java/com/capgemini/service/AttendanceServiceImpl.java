package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	@Autowired
	AttendanceRepository arepo;

	@Override
	public AttendanceEntity addAttendance(AttendanceEntity entity)
	{
		
		return arepo.save(entity);	
	}

	@Override
	public AttendanceEntity updateAttendance(AttendanceEntity entity) {
		int id = entity.getAttendanceId();
		AttendanceEntity ae = (AttendanceEntity) arepo.findById(id).orElse(null);
		//ae.setDate(entity.getDate());
		ae.setSemester(entity.getSemester());
		ae.setStatus(entity.getStatus());
		arepo.save(ae);
	    return ae;
	}

	@Override
	public String deleteAttendance(AttendanceEntity entity) {
		arepo.delete(entity);
	
		return "Deleted";
	}
	
	@Override
	public AttendanceEntity getAttendanceById(int attendanceId) 
	{
		AttendanceEntity ae = arepo.findById(attendanceId).orElse(null);		
		return ae;
	}
}
