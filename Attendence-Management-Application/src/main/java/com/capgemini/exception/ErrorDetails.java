package com.capgemini.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime date;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.date = localDateTime;
		this.message = message;
		this.details = details;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
