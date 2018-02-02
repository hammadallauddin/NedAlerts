package com.appdroid.nedians;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Hammad Allauddin on 4/5/2017.
 */

public class CheckConn{
    private static final String TAG = CheckConn.class.getSimpleName();

    public static boolean isOnline(Context paramContext)
    {
        @SuppressLint("WrongConstant") NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return (localNetworkInfo != null) && (localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected());
    }


}
