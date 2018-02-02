package com.appdroid.nedians;

import android.content.ActivityNotFoundException;
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

public class Feedback extends AppCompatActivity {
    LinearLayout r1,r2;
    CheckConn chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        r1 = (LinearLayout) findViewById(R.id.rf1);
        r2 = (LinearLayout) findViewById(R.id.rf2);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chk.isOnline(getApplicationContext())==true){
                    mail();
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
                    playStore();
                }
                else {
                    Toast.makeText(getApplicationContext(),"No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });


        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


    public void mail(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_SUBJECT,"FEEDBACK");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{"hammadallauddin@gmail.com"});

        try {
            startActivity(Intent.createChooser(i,"SEND FEEDBACK"));
        }catch (ActivityNotFoundException e){
            Toast.makeText(getApplicationContext(),"Please Install email client before sending feedback",Toast.LENGTH_SHORT).show();
        }
    }

    public void playStore(){
        Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName())));
        }
    }
}