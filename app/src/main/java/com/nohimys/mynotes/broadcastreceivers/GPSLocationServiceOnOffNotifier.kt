package com.nohimys.mynotes.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.widget.Toast

import com.nohimys.mynotes.utils.GpsLocationUtil

/**
 * Created by Nohim Sandeepa on 8/22/2017.
 */

class GPSLocationServiceOnOffNotifier : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.matches("android.location.PROVIDERS_CHANGED".toRegex())) {
            //Toast.makeText(context, "in android.location.PROVIDERS_CHANGED",Toast.LENGTH_SHORT).show();

            val contentResolver = context.contentResolver
            // Find out what the settings say about which providers are enabled
            val mode = Settings.Secure.getInt(
                    contentResolver, Settings.Secure.LOCATION_MODE, Settings.Secure.LOCATION_MODE_OFF)

            if (mode == Settings.Secure.LOCATION_MODE_OFF) {
                Toast.makeText(context, "LOCATION_MODE_OFF", Toast.LENGTH_SHORT).show()
                GpsLocationUtil.getInstance().onGpsLocationOff()
            } else if (mode == Settings.Secure.LOCATION_MODE_SENSORS_ONLY || mode == Settings.Secure.LOCATION_MODE_HIGH_ACCURACY) {
                Toast.makeText(context, "LOCATION_MODE_ON ", Toast.LENGTH_SHORT).show()
                GpsLocationUtil.getInstance().onGpsLocationOn()
            }


            //            String locationMode = "Empty";
            //            if (mode != Settings.Secure.LOCATION_MODE_OFF) {
            //                if (mode == Settings.Secure.LOCATION_MODE_HIGH_ACCURACY) {
            //                    locationMode = "High accuracy. Uses GPS, Wi-Fi, and mobile networks to determine location";
            //                } else if (mode == Settings.Secure.LOCATION_MODE_SENSORS_ONLY) {
            //                    locationMode = "Device only. Uses GPS to determine location";
            //                } else if (mode == Settings.Secure.LOCATION_MODE_BATTERY_SAVING) {
            //                    locationMode = "Battery saving. Uses Wi-Fi and mobile networks to determine location";
            //                }
            //            }
            //            else if (mode == Settings.Secure.LOCATION_MODE_OFF){
            //                locationMode = "GPS Off";
            //            }
            //            Toast.makeText(context,locationMode,Toast.LENGTH_SHORT).show();
        }
    }
}
