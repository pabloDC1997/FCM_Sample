package com.example.brunoandrade.tabajaras.ui.notification;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.brunoandrade.tabajaras.R;
import com.example.brunoandrade.tabajaras.model.DataMessageRequest;
import com.example.brunoandrade.tabajaras.ui.notification.adapter.NotificationAdapter;
import com.example.brunoandrade.tabajaras.ui.notification.adapter.TouchListenerCallback;
import com.example.brunoandrade.tabajaras.util.TinyDB;

import java.util.List;

public class NotificationsActivity extends AppCompatActivity implements TouchListenerCallback {

    private static final String TAG = NotificationsActivity.class.getName();

    List<DataMessageRequest> listResquestMessages;
    TinyDB tinyDB;
    NotificationAdapter mAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setTitle("Solicitações");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        this.tinyDB = new TinyDB(this);
        Bundle bundle = getIntent().getExtras();
        this.listResquestMessages = (List<DataMessageRequest>) bundle.getSerializable("LIST_REQUEST_MESSAGES");
        startRecycleView(this.listResquestMessages);
    }

    private void startRecycleView(List<DataMessageRequest> listResquestMessages) {
        this.mAdapter = new NotificationAdapter(listResquestMessages,this);
        this.linearLayoutManager = new LinearLayoutManager(this);
        this.linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(this.mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//clicks btn itens
    @Override
    public void onClickAccept(View view, int position) {
        System.out.println(position);
    }

    @Override
    public void onClickDecline(View view, int position) {
        System.out.println(position);
    }
}
