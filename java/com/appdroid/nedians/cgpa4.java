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

public class cgpa4 extends Activity
{
  Button bc41;
  EditText ec41,ec42,ec43,ec44,ec45,sc41,sc42,sc43,sc44,sc45;
  TextView tv41;

  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D,d9 = 0.0D,d10 = 0.0D,d11 = 0.0D,d12 = 0.0D,d13 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec41.getText().toString());
      d2 = Double.parseDouble(this.ec42.getText().toString());
      d3 = Double.parseDouble(this.ec43.getText().toString());
      d4 = Double.parseDouble(this.ec44.getText().toString());
      d5 = Double.parseDouble(this.ec45.getText().toString());


      d9  = Double.parseDouble(this.sc41.getText().toString());
      d10 = Double.parseDouble(this.sc42.getText().toString());
      d11 = Double.parseDouble(this.sc43.getText().toString());
      d12 = Double.parseDouble(this.sc44.getText().toString());
      d13 = Double.parseDouble(this.sc45.getText().toString());

      if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D))
      {
        Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
      }
      else{
        double d17 = ((d1 * d9) + (d2 * d10) + (d3 * d11) + (d4 * d12) + (d5 * d13)) / ( d13 + d12 + d11 + d10 + d9);
        String str = new DecimalFormat("#.##").format(d17);
        tv41.setText("CGPA = " + str);
      }

    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec41.setText("");
    ec42.setText("");
    ec43.setText("");
    ec44.setText("");
    ec45.setText("");

    sc41.setText("");
    sc42.setText("");
    sc43.setText("");
    sc44.setText("");
    sc45.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_4);


    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    ec41 = (EditText) findViewById(R.id.ec41);
    ec42 = (EditText) findViewById(R.id.ec42);
    ec43 = (EditText) findViewById(R.id.ec43);
    ec44 = (EditText) findViewById(R.id.ec44);
    ec45 = (EditText) findViewById(R.id.ec45);


    sc41 = (EditText) findViewById(R.id.sc41);
    sc42 = (EditText) findViewById(R.id.sc42);
    sc43 = (EditText) findViewById(R.id.sc43);
    sc44 = (EditText) findViewById(R.id.sc44);
    sc45 = (EditText) findViewById(R.id.sc45);

    tv41 = (TextView) findViewById(R.id.tc41);
    bc41 = (Button) findViewById(R.id.bc41);

    bc41.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });
  }
}
