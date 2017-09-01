package com.example.brunoandrade.tabajaras.fcm;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.example.brunoandrade.tabajaras.model.Data;
import com.example.brunoandrade.tabajaras.model.DataMessageRequest;
import com.example.brunoandrade.tabajaras.model.VendasM;
import com.example.brunoandrade.tabajaras.ui.MainActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bruno.andrade on 29/12/2016.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private String TAG = MyFirebaseMessagingService.class.getName();
    public static final String FCM_INTENT_FILTER = "FCM_INTENT_FILTER";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            if (remoteMessage.getData() != null) {
                DataMessageRequest dataMessageRequest = getDataMassageObject(remoteMessage);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", dataMessageRequest);
                Intent intent = new Intent(FCM_INTENT_FILTER);
                intent.putExtras(bundle);
                sendBroadcast(intent);
            }
        } catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }

    private DataMessageRequest getDataMassageObject(RemoteMessage remoteMessage) {
        Gson gson = new GsonBuilder().create();
        String matriculaUsuario = remoteMessage.getData().get("matriculaUsuario");
        String idCaixa = remoteMessage.getData().get("idCaixa");
        String operador = remoteMessage.getData().get("operador");
        long dataSolicitacao = Long.parseLong(remoteMessage.getData().get("dataSolicitacao"));
        String vendasListMessage = remoteMessage.getData().get("vendasListMessage");
        VendasM[] vendasM =  gson.fromJson(vendasListMessage, VendasM[].class);
        List<VendasM> vm = Arrays.asList(vendasM);
        Data data1 = new Data(operador,dataSolicitacao,idCaixa,matriculaUsuario,vm);
        return new DataMessageRequest(data1);
    }
}
