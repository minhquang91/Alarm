package com.lucky.alarmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView txt_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txt_display = (TextView) findViewById(R.id.txt_display);
        String name = getIntent().getStringExtra("extras");
        txt_display.setText(name);

    }
}
