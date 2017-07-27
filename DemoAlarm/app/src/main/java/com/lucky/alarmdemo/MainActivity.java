package com.lucky.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TimePicker mTimePicker;
    CheckBox mCbMon, mCbTue, mCbWed, mCbThur, mCbFri, mCbSat, mCbSun;
    Button btnStart, btnCancel;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mTimePicker = (TimePicker) findViewById(R.id.timePicker);
        mCbMon = (CheckBox) findViewById(R.id.cbMon);
        mCbTue = (CheckBox) findViewById(R.id.cbTue);



        mCbWed = (CheckBox) findViewById(R.id.cbWed);
        mCbThur = (CheckBox) findViewById(R.id.cbThur);
        mCbFri = (CheckBox) findViewById(R.id.cbFri);
        mCbSat = (CheckBox) findViewById(R.id.cbSat);
        mCbSun = (CheckBox) findViewById(R.id.cbSun);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnCancel = (Button) findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnStart) {
            if (mCbMon.isChecked()) {
                forDay(2,"mon");
            }
            if (mCbTue.isChecked()) {
                forDay(3,"tue");
                Log.e("ahihi","3");
            }
            if (mCbWed.isChecked()) {
                forDay(4,"wed");
            }
            if (mCbThur.isChecked()) {
                forDay(5,"thur");
            }
            if (mCbFri.isChecked()) {
                forDay(6,"six");
            }
            if (mCbSat.isChecked()) {
                forDay(7,"sat");
            }
            if (mCbSun.isChecked()) {
                forDay(1,"sun");
            }
        } else if (id == R.id.btnStop) {

        }
    }

    private void forDay(int day,String name) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, day);
        calendar.set(Calendar.HOUR_OF_DAY, mTimePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, mTimePicker.getCurrentMinute());
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        intent.putExtra("extras",name);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, day, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY * 7, pendingIntent);
    }
}
