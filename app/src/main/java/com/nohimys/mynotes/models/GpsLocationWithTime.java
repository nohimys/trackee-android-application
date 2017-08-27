package com.nohimys.mynotes.models;

/**
 * Created by Nohim Sandeepa on 8/27/2017.
 */

public class GpsLocationWithTime {
    private GpsLocation gpsLocation;
    private String reportedDateTime;

    public GpsLocation getGpsLocation() {
        return gpsLocation;
    }

    public void setGpsLocation(GpsLocation gpsLocation) {
        this.gpsLocation = gpsLocation;
    }

    public String getReportedDateTime() {
        return reportedDateTime;
    }

    public void setReportedDateTime(String reportedDateTime) {
        this.reportedDateTime = reportedDateTime;
    }
}
