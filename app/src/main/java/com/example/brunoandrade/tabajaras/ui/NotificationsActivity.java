package com.example.brunoandrade.tabajaras.ui;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.brunoandrade.tabajaras.R;
import com.example.brunoandrade.tabajaras.model.Data;
import com.example.brunoandrade.tabajaras.model.DataMessageRequest;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationsActivity extends AppCompatActivity {

    private static final String TAG = NotificationsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setTitle("DIALOG TESTE");
        
        Bundle bundle = getIntent().getExtras();
        if (!bundle.isEmpty()) {
            DataMessageRequest data = (DataMessageRequest) bundle.getSerializable("data");
            if (data != null) {
                new AlertDialog.Builder(this)
                        .setTitle("Aprovar cancelamento?\n Operadora: "
                                + data.getData().getOperadora()
                                + "\nMatricula:"
                                + data.getData().getMatriculaUsuario()
                                + "Caixa: " + data.getData().getIdCaixa())
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create().show();
            }
        } else {
            Log.i(TAG, "Bundle está vazio");
        }
    }
}
