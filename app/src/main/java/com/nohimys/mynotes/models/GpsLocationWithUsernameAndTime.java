package com.nohimys.mynotes.models;

import com.nohimys.mynotes.models.GpsLocation;

public class GpsLocationWithUsernameAndTime {
	private String username;
	private GpsLocation gpsLocation;
	private String reportedDateTime;
	
	public String getReportedDateTime() {
		return reportedDateTime;
	}
	public void setReportedDateTime(String reportedDateTime) {
		this.reportedDateTime = reportedDateTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GpsLocation getGpsLocation() {
		return gpsLocation;
	}
	public void setGpsLocation(GpsLocation gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	
	
}
