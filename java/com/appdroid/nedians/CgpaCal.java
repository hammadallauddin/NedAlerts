package com.appdroid.nedians;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CgpaCal extends AppCompatActivity {
    Spinner sp031;
    Button b031;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpa_cal);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sp031 = (Spinner) findViewById(R.id.sp031);
        b031 = (Button) findViewById(R.id.b031);
        b031.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = sp031.getSelectedItem().toString();
                switch (str){
                    case "-Select Semesters-":
                        Toast.makeText(getApplicationContext(),"Select Any Option",Toast.LENGTH_LONG).show();
                        break;
                    case "2":
                        startActivity(new Intent(CgpaCal.this,cgpa1.class));
                        break;
                    case "3":
                        startActivity(new Intent(CgpaCal.this,cgpa2.class));
                        break;
                    case "4":
                        startActivity(new Intent(CgpaCal.this,cgpa3.class));
                        break;
                    case "5":
                        startActivity(new Intent(CgpaCal.this,cgpa4.class));
                        break;
                    case "6":
                        startActivity(new Intent(CgpaCal.this,cgpa5.class));
                        break;
                    case "7":
                        startActivity(new Intent(CgpaCal.this,cgpa6.class));
                        break;
                    case "8":
                        startActivity(new Intent(CgpaCal.this,cgpa7.class));
                        break;
                }
            }
        });
    }
}
