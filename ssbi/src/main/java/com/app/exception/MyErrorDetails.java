package com.app.exception;

import java.time.LocalDate;

public class MyErrorDetails {

	private LocalDate timeStamp;
	private String message;
	private String discription;
	public MyErrorDetails(LocalDate timeStamp, String message, String discription) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.discription = discription;
	}
	public MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public String toString() {
		return "MyErrorDetails [timeStamp=" + timeStamp + ", message=" + message + ", discription=" + discription + "]";
	}
	
	
	
	
}
