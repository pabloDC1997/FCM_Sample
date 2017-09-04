package com.example.brunoandrade.tabajaras.ui.notification.adapter;

import android.view.View;

/**
 * Created by pablo.couto on 04/09/2017.
 */

public interface TouchListenerCallback {
    void onClickAccept(View view, int position);
    void onClickDecline(View view, int position);
}
