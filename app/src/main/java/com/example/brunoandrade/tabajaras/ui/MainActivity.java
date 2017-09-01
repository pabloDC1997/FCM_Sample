package com.example.brunoandrade.tabajaras.ui;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.brunoandrade.tabajaras.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int COUNT = 0;
    private TextView tvMenu;
    private ImageView ivMenu;
    Button btn_teste;
    private RelativeLayout mRlMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_teste = (Button) findViewById(R.id.btn_teste);
        btn_teste.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.badge);
        MenuItemCompat.setActionView(item, R.layout.actionbar_menu_layout);
        RelativeLayout rlMenu = (RelativeLayout)   MenuItemCompat.getActionView(item);

        if (COUNT <= 0){
            ((TextView) rlMenu.findViewById(R.id.actionbar_notifcation_textview)).setVisibility(View.GONE);
        } else {
            ((TextView) rlMenu.findViewById(R.id.actionbar_notifcation_textview)).setVisibility(View.VISIBLE);
            if (COUNT > 99) {
                ((TextView) rlMenu.findViewById(R.id.actionbar_notifcation_textview)).setText(String.valueOf("99+"));
            } else {
                ((TextView) rlMenu.findViewById(R.id.actionbar_notifcation_textview)).setText(String.valueOf(COUNT));
            }
        }
        mRlMenu = rlMenu;

        return true;
    }

    @Override
    public void onClick(View v) {
        COUNT ++;
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

}
