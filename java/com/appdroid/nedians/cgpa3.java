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

public class cgpa3 extends Activity
{
  Button bc31;
  EditText ec31,ec32,ec33,ec34,sc31,sc32,sc33,sc34;
  TextView tv31;

  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d9 = 0.0D,d10 = 0.0D,d11 = 0.0D,d12 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec31.getText().toString());
      d2 = Double.parseDouble(this.ec32.getText().toString());
      d3 = Double.parseDouble(this.ec33.getText().toString());
      d4 = Double.parseDouble(this.ec34.getText().toString());


      d9  = Double.parseDouble(this.sc31.getText().toString());
      d10 = Double.parseDouble(this.sc32.getText().toString());
      d11 = Double.parseDouble(this.sc33.getText().toString());
      d12 = Double.parseDouble(this.sc34.getText().toString());

      if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D))
      {
        Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
      }
      else{
        double d17 = ((d1 * d9) + (d2 * d10) + (d3 * d11) + (d4 * d12)) / ( d12 + d11 + d10 + d9);
        String str = new DecimalFormat("#.##").format(d17);
        tv31.setText("CGPA = " + str);
      }

    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec31.setText("");
    ec32.setText("");
    ec33.setText("");
    ec34.setText("");

    sc31.setText("");
    sc32.setText("");
    sc33.setText("");
    sc34.setText("");

  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_3);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    ec31 = (EditText) findViewById(R.id.ec31);
    ec32 = (EditText) findViewById(R.id.ec32);
    ec33 = (EditText) findViewById(R.id.ec33);
    ec34 = (EditText) findViewById(R.id.ec34);

    sc31 = (EditText) findViewById(R.id.sc31);
    sc32 = (EditText) findViewById(R.id.sc32);
    sc33 = (EditText) findViewById(R.id.sc33);
    sc34 = (EditText) findViewById(R.id.sc34);

    tv31 = (TextView) findViewById(R.id.tc31);
    bc31 = (Button) findViewById(R.id.bc31);

    bc31.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });
  }
}
