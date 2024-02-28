package com.chaitu.springboot.batterymanagementclient.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class BatteryData {
	
	private long id;
	
	private long batteryid;
	
	private double current;
	
	private double voltage;
	
	private float temperature;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime datetime;
	
	private String formateddatetime;
	
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

	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public double getVoltage() {
		return voltage;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getFormateddatetime() {
		return formateddatetime;
	}

	public void setFormateddatetime(String formateddatetime) {
		this.formateddatetime = formateddatetime;
	}
	
	
	

}
