package com.appdroid.nedians;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class cgpa2 extends Activity
{
  Button bc21;
  EditText ec21,ec22,ec23,sc21,sc22,sc23;
  TextView tv21;

  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d9 = 0.0D,d10 = 0.0D,d11 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec21.getText().toString());
      d2 = Double.parseDouble(this.ec22.getText().toString());
      d3 = Double.parseDouble(this.ec23.getText().toString());


      d9  = Double.parseDouble(this.sc21.getText().toString());
      d10 = Double.parseDouble(this.sc22.getText().toString());
      d11 = Double.parseDouble(this.sc23.getText().toString());


        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D))
        {
            Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
        }
        else{
            double d17 = ((d1 * d9) + (d2 * d10) + (d3 * d11)) / ( d11 + d10 + d9);
            String str = new DecimalFormat("#.##").format(d17);
            tv21.setText("CGPA = " + str);
        }
    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec21.setText("");
    ec22.setText("");
    ec23.setText("");

    sc21.setText("");
    sc22.setText("");
    sc23.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_2);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    ec21 = (EditText) findViewById(R.id.ec21);
    ec22 = (EditText) findViewById(R.id.ec22);
    ec23 = (EditText) findViewById(R.id.ec23);

    sc21 = (EditText) findViewById(R.id.sc21);
    sc22 = (EditText) findViewById(R.id.sc22);
    sc23 = (EditText) findViewById(R.id.sc23);

    tv21 = (TextView) findViewById(R.id.tc21);
    bc21 = (Button) findViewById(R.id.bc21);

    bc21.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });
  }
}
