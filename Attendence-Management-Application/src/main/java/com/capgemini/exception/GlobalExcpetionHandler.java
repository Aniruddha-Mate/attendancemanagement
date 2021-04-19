package com.capgemini.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExcpetionHandler {
	
	@ExceptionHandler(FacultyNotFoundException.class)
    public ResponseEntity<ErrorDetails> facultyNotFoundException(FacultyNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorDetails> recordNotFoundException(RecordNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(AttendanceIdNotFoundException.class) 
	public ResponseEntity<ErrorDetails> attendanceIdNotFoundException(Exception ex, WebRequest request) { 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND); }

	@ExceptionHandler(CourseIdNotFoundException.class) 
	public ResponseEntity<ErrorDetails> sourseIdNotFoundException(Exception ex, WebRequest request) { 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND); }

	@ExceptionHandler(SubjectNotFoundException.class) 
	public ResponseEntity<ErrorDetails> subjectNotFoundException(Exception ex, WebRequest request) { 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND); }

	@ExceptionHandler(StudentNotFoundException.class) 
	public ResponseEntity<ErrorDetails> studentNotFoundException(Exception ex, WebRequest request) { 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND); }
	
	@ExceptionHandler(DuplicateRecordException.class) 
	public ResponseEntity<ErrorDetails> duplicateRecordException(Exception ex, WebRequest request) { 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND); }
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<ErrorDetails> globleExcpetionHandler(Exception ex, WebRequest request) { 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	  	return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); }
	
	
}
