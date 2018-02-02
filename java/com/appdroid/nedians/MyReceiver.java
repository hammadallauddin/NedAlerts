package com.appdroid.nedians;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver
{
    public void onReceive(Context paramContext, Intent paramIntent)
    {
        try {

            paramContext.startService(new Intent(paramContext, MyService.class));
        }
        catch (Exception localException) {
            localException.printStackTrace();
        }
    }
}