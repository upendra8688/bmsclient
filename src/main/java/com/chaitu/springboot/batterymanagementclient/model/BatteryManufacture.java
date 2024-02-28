package com.chaitu.springboot.batterymanagementclient.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class BatteryManufacture {
	
	
	private long id;
	
	private long batteryid;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime manufacture_datetime;
	
	private String formatteddatetime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBatteryid() {
		return batteryid;
	}

	public void setBatteryid(long batteryid) {
		this.batteryid = batteryid;
	}

	public LocalDateTime getManufacture_datetime() {
		return manufacture_datetime;
	}

	public void setManufacture_datetime(LocalDateTime manufacture_datetime) {
		this.manufacture_datetime = manufacture_datetime;
	}

	public String getFormatteddatetime() {
		return formatteddatetime;
	}

	public void setFormatteddatetime(String formatteddatetime) {
		this.formatteddatetime = formatteddatetime;
	}
	
	

}
