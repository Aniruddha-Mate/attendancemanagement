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
    public ResponseEntity<ErrorDetails> FacultyNotFoundException(FacultyNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorDetails> RecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class) 
	  public ResponseEntity<ErrorDetails> globleExcpetionHandler(Exception ex, WebRequest request) { ErrorDetails
	  errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR); }


}
