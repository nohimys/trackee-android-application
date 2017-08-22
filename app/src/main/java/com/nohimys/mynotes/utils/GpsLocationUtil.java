package com.nohimys.mynotes.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/**
 * Created by Nohim Sandeepa on 8/22/2017.
 */

public class GpsLocationUtil {
    private static GpsLocationUtil myInstance;

    private boolean isGpsOn;

    private GpsLocationUtil(){
    }

    public synchronized static GpsLocationUtil getInstance(){
        if(myInstance == null){
            myInstance = new GpsLocationUtil();
        }
        return myInstance;
    }

    public void init(Context context){
        isGpsOn = this.checkIsGpsLocationOn(context);
    }

    public void onGpsLocationOn(){
        if(!isGpsOn){
            isGpsOn = true;

            //
        }
    }

    public void onGpsLocationOff(){
        if(isGpsOn){
            isGpsOn = false;

            //
        }
    }

    private boolean checkIsGpsLocationOn(Context context){
        ContentResolver contentResolver = context.getContentResolver();
        // Find out what the settings say about which providers are enabled
        int mode = Settings.Secure.getInt(
                contentResolver, Settings.Secure.LOCATION_MODE, Settings.Secure.LOCATION_MODE_OFF);

        if (mode == Settings.Secure.LOCATION_MODE_OFF){
            return false;
        }
        else if(mode == Settings.Secure.LOCATION_MODE_SENSORS_ONLY || mode == Settings.Secure.LOCATION_MODE_HIGH_ACCURACY){
            return true;
        }
        return false;
    }
}
