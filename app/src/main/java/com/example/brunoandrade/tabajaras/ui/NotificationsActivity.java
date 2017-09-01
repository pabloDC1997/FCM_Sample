package com.example.brunoandrade.tabajaras.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.brunoandrade.tabajaras.R;

public class NotificationsActivity extends AppCompatActivity {

    private static final String TAG = NotificationsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setTitle("Solicitações");
    }
}
