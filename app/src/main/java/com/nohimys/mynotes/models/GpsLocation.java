package com.nohimys.mynotes.models;

import java.math.BigDecimal;

public class GpsLocation {
	private BigDecimal latitude;
	private BigDecimal longitude;
	
	public GpsLocation() {		
	}
	
	public GpsLocation(BigDecimal latitude, BigDecimal longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
}
