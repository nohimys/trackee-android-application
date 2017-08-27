package com.nohimys.mynotes.util;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Nohim Sandeepa on 8/24/2017.
 */

public class DateTimeOperations {
    private static final String DATE_TIME_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String LOG_TAG = DateTimeOperations.class.getSimpleName();

    private DateTimeOperations() {
        // Private constructor to avoid creating instances
    }

    public static Date getDateFromString(String dateTimeString) {

        try {
            DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_STRING_FORMAT);
            Date date = dateFormat.parse(dateTimeString);
            return date;
        } catch (ParseException ex) {
            Log.e(LOG_TAG,"Error converting String Date to the Date Type");
            return null;
        }
    }

    public static String getStringFromDate(Date date) {

        DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_STRING_FORMAT);
        return dateFormat.format(new Date(date.getTime()));
    }

    public static Date getNow(){
        return Calendar.getInstance().getTime();
    }

    public static String getNowAsString() {
        return getStringFromDate(getNow());
    }

    public static int getDateTimeDifferenceInMinutes(Date dateBefore, Date dateAfter){
        long differenceInMiliseconds = dateAfter.getTime() - dateBefore.getTime();

        return (int)differenceInMiliseconds/1000/60;
    }
}
