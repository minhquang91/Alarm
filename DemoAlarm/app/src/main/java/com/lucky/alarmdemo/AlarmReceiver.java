package com.lucky.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Minh Quang on 7/26/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("ahihi","AlarmReceiver");
        String name = intent.getStringExtra("name");
        Intent alarmIntent = new Intent(context,AlarmService.class);
        alarmIntent.putExtra("extras",name);
        context.startService(alarmIntent);
    }
}
