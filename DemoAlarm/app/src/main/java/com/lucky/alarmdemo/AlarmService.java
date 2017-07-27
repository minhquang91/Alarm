package com.lucky.alarmdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Minh Quang on 7/26/2017.
 */

public class AlarmService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Ahihi","chao service");
        String name= intent.getStringExtra("extras");
        Intent i = new Intent(this,DisplayActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("extras",name);
        startActivity(i);
        return START_NOT_STICKY;
    }
}
