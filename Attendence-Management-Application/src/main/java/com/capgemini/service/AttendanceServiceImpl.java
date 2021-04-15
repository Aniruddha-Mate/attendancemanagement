package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<AttendanceEntity> getAttendance() {
		List<AttendanceEntity> le = new ArrayList<>();
		le = arepo.findAll();
		return le;
	}
	
	@Override
	public AttendanceEntity updateAttendanceById(int attendanceId, AttendanceEntity entity) {
		AttendanceEntity ae = arepo.findById(attendanceId).orElse(null);
	    ae.setSemester(entity.getSemester());
	    ae.setStatus(entity.getStatus());
	    ae.setCurrentDate(entity.getCurrentDate());
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
	@Override
	public String deleteById(int attendanceId) {
		arepo.deleteById(attendanceId);
		return "DELETED BY ID";
	}
}
