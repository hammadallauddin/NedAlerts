package com.appdroid.nedians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Calculator extends AppCompatActivity {
    LinearLayout r1, r2;
    CheckConn chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        r1 = (LinearLayout) findViewById(R.id.rc1);
        r2 = (LinearLayout) findViewById(R.id.rc2);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(Calculator.this,GpaCal.class));
            }
        });


        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Calculator.this,CgpaCal.class));
            }
        });

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}