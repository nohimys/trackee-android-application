package com.nohimys.mynotes.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

import com.nohimys.mynotes.helpers.InternetConnectionHelper

/**
 * Created by Nohim Sandeepa on 8/22/2017.
 */

class InternetConnectionChangeNotifier : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val cm = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo

        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting

        if (isConnected) {
            InternetConnectionHelper.onInternetConnected()
            Toast.makeText(context, "Internet Connected", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Internet Disonnected", Toast.LENGTH_SHORT).show()
            InternetConnectionHelper.onInternetDisconnected()
        }
    }
}
