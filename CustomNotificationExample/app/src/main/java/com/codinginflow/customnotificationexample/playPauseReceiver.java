package com.codinginflow.customnotificationexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

public class playPauseReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("test btn", "play!!");
        Toast.makeText(context, "Play-Pause Song", Toast.LENGTH_LONG).show();
    }

}