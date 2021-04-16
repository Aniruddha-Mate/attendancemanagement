package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.AttendanceEntity;
import com.capgemini.exception.AttendanceIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	List<AttendanceEntity> attendanceList;
	
	@Autowired
	AttendanceRepository attendanceRepository;

	//For adding the attendance one by one
	@Override
	public AttendanceEntity addAttendance(AttendanceEntity entity)
	{
		return attendanceRepository.save(entity);	
	}
	
	//For Getting the details of all the attendance present in the database
	@Override
	public List<AttendanceEntity> getAttendance() throws RecordNotFoundException{
		attendanceList = new ArrayList<>();
		attendanceList = attendanceRepository.findAll();
		if(attendanceList.isEmpty())
			throw new RecordNotFoundException("No Data In The Database Available");
		return attendanceList;
	}
    
	//For Getting the details of the attendance by Attendance ID
	@Override
	public AttendanceEntity getAttendanceById(int attendanceId) throws AttendanceIdNotFoundException {
		Supplier<AttendanceIdNotFoundException> supplier = ()-> new AttendanceIdNotFoundException("Given id Is Not Present In The Database");
		AttendanceEntity attendanceEntity = attendanceRepository.findById(attendanceId).orElseThrow(supplier);
		return attendanceEntity;
	}
	
	//For Updating the details of the Attendance By Attendance ID
	@Override
	public AttendanceEntity updateAttendanceById(int attendanceId, AttendanceEntity entity) throws AttendanceIdNotFoundException{
		Supplier<AttendanceIdNotFoundException> supplier = ()-> new AttendanceIdNotFoundException("Given Id Is Not Present In The Database");
		AttendanceEntity attendanceEntity = attendanceRepository.findById(attendanceId).orElseThrow(supplier);
		attendanceEntity.setSemester(entity.getSemester());
		attendanceEntity.setStatus(entity.getStatus());
		attendanceEntity.setStudent(entity.getStudent());
		attendanceEntity.setCurrentDate(entity.getCurrentDate());
		
	    attendanceRepository.save(attendanceEntity);
	    return attendanceEntity;
	}
	
	//For deleting records of Attendance by Attendance ID
	@Override
	public String deleteById(int attendanceId) throws RecordNotFoundException {
		Supplier<RecordNotFoundException> supplier = ()-> new RecordNotFoundException("Given Id Is Not Present In The Database");
		attendanceRepository.findById(attendanceId).orElseThrow(supplier);
		attendanceRepository.deleteById(attendanceId);
		return "DELETED BY ID";
	}

}
