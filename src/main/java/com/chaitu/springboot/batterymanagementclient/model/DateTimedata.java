package com.chaitu.springboot.batterymanagementclient.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class DateTimedata {
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime datetime;

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	

}
