package com.example.brunoandrade.tabajaras.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.brunoandrade.tabajaras.R;
import com.example.brunoandrade.tabajaras.fcm.MyFirebaseMessagingService;
import com.example.brunoandrade.tabajaras.model.DataMessageRequest;
import com.example.brunoandrade.tabajaras.ui.notification.NotificationsActivity;
import com.example.brunoandrade.tabajaras.util.TinyDB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private static int COUNT = 0;
    private RelativeLayout mRlMenu;
    List<DataMessageRequest> listResquestMessages;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tinyDB = new TinyDB(this);
        listResquestMessages = new ArrayList<>();
        registerReceiver(myReceiver, new IntentFilter(MyFirebaseMessagingService.FCM_INTENT_FILTER));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.badge);
        MenuItemCompat.setActionView(item, R.layout.actionbar_menu_layout);
        RelativeLayout rlMenu = (RelativeLayout)   MenuItemCompat.getActionView(item);
        mRlMenu = rlMenu;
        ImageView imageView = (ImageView) mRlMenu.findViewById(R.id.image_view_example);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listResquestMessages.size() > 0) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("LIST_REQUEST_MESSAGES", (Serializable) listResquestMessages);
                    Intent intent = new Intent(getApplicationContext(), NotificationsActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        updateNotificationsMenu();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.badge:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onNotificationReceived(intent);
        }
    };

    private void onNotificationReceived(Intent intent) {
        DataMessageRequest data  = (DataMessageRequest) intent.getExtras().getSerializable("data");
        this.listResquestMessages.add(data);
        updateNotificationsMenu();
    }

    private void updateNotificationsMenu() {
        COUNT = this.listResquestMessages.size();
        if (COUNT <= 0){
            ((TextView) mRlMenu.findViewById(R.id.actionbar_notifcation_textview)).setVisibility(View.GONE);
        } else {
            ((TextView) mRlMenu.findViewById(R.id.actionbar_notifcation_textview)).setVisibility(View.VISIBLE);
            if (COUNT > 99) {
                ((TextView) mRlMenu.findViewById(R.id.actionbar_notifcation_textview)).setText(String.valueOf("99+"));
            } else {
                ((TextView) mRlMenu.findViewById(R.id.actionbar_notifcation_textview)).setText(String.valueOf(COUNT));
            }
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }
}
