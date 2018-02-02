package com.appdroid.nedians;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Social extends AppCompatActivity {

    LinearLayout rs1,rs2;
    CheckConn chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        rs1 = (LinearLayout) findViewById(R.id.rs1);
        rs2 = (LinearLayout) findViewById(R.id.rs2);
        rs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    Intent i = getOpenFacebookIntent(getApplicationContext());
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("twitter://user?screen_name=neduniversity"));
                        startActivity(intent);

                    }catch (Exception e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://twitter.com/#!/neduniversity")));
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/neduniversityofengineering"));
        } catch (Exception e) {
           return null;
        }
    }
}

