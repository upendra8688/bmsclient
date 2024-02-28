package com.chaitu.springboot.batterymanagementclient.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ConstraintDateTime {
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startdatetime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime enddatetime;
	public LocalDateTime getStartdatetime() {
		return startdatetime;
	}
	public void setStartdatetime(LocalDateTime startdatetime) {
		this.startdatetime = startdatetime;
	}
	public LocalDateTime getEnddatetime() {
		return enddatetime;
	}
	public void setEnddatetime(LocalDateTime enddatetime) {
		this.enddatetime = enddatetime;
	}
	
	

}
