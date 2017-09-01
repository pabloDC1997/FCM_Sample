package com.example.brunoandrade.tabajaras.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

/**
 * Created by bruno.andrade on 29/12/2016.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
        String token = null;
        try {
            token = FirebaseInstanceId.getInstance().getToken("763892422526", "FCM");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("Firebase token", token);
        
    }
}
