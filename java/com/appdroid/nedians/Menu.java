package com.appdroid.nedians;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;



public class Menu extends AppCompatActivity {
    LinearLayout r1,r2,r3,r4,r6,r7,r8,r9;
    CheckConn chk;
    AdView mAdView; AdRequest adRequest;

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg){
            mAdView.loadAd(adRequest);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mAdView = (AdView) findViewById(R.id.adView);
        r1 = (LinearLayout) findViewById(R.id.r1);
        r2 = (LinearLayout) findViewById(R.id.r2);
        r3 = (LinearLayout) findViewById(R.id.r3);
        r4 = (LinearLayout) findViewById(R.id.r4);
        r6 = (LinearLayout) findViewById(R.id.r6);
        r7 = (LinearLayout) findViewById(R.id.r7);
        r8 = (LinearLayout) findViewById(R.id.r8);
        r9 = (LinearLayout) findViewById(R.id.r9);

        Thread t = new Thread() {
            @Override
            public void run(){
                MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
                adRequest = new AdRequest.Builder().build();
                h.sendEmptyMessage(0);
            }
        };
        t.start();




        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    startActivity(new Intent(Menu.this,Alerts.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    startActivity(new Intent(Menu.this,VisitWeb.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    startActivity(new Intent(Menu.this,Map.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Calculator.class));
            }
        });


        r6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Social.class));
            }
        });


        r7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this,Feedback.class));
            }
        });


        r8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    startActivity(new Intent(Menu.this,News.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


        r9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    startActivity(new Intent(Menu.this,Events.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


        if (chk.isOnline(getApplicationContext())==true){
            startService(new Intent(Menu.this, MyService.class));
        }
    }
}
