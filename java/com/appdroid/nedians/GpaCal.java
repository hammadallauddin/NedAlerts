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

public class GpaCal extends AppCompatActivity {
    Button b021;
    Spinner sp021;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpa_cal);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        sp021 = (Spinner) findViewById(R.id.sp02);
        b021 = (Button) findViewById(R.id.b021);

        b021.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = sp021.getSelectedItem().toString();
                switch (str){
                    case "-Select Courses-":
                        Toast.makeText(getApplicationContext(),"Select Any Option",Toast.LENGTH_LONG).show();
                        break;
                    case "2":
                        startActivity(new Intent(GpaCal.this,gpa1.class));
                        break;
                    case "3":
                        startActivity(new Intent(GpaCal.this,gpa2.class));
                        break;
                    case "4":
                        startActivity(new Intent(GpaCal.this,gpa3.class));
                        break;
                    case "5":
                        startActivity(new Intent(GpaCal.this,gpa4.class));
                        break;
                    case "6":
                        startActivity(new Intent(GpaCal.this,gpa5.class));
                        break;
                    case "7":
                        startActivity(new Intent(GpaCal.this,gpa6.class));
                        break;
                }
            }
        });
    }
}
