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

public class cgpa1 extends Activity
{
  Button bc11;
  EditText ec11,ec12,sc11,sc12;
  TextView tv11;

  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d9 = 0.0D,d10 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec11.getText().toString());
      d2 = Double.parseDouble(this.ec12.getText().toString());


      d9  = Double.parseDouble(this.sc11.getText().toString());
      d10 = Double.parseDouble(this.sc12.getText().toString());

      if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D))
      {
        Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
      }
      else{
        double d17 = ((d1 * d9) + (d2 * d10)) / ( d10 + d9);
        String str = new DecimalFormat("#.##").format(d17);
        tv11.setText("CGPA = " + str);
      }

    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec11.setText("");
    ec12.setText("");

    sc11.setText("");
    sc12.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_1);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);


    ec11 = (EditText) findViewById(R.id.ec11);
    ec12 = (EditText) findViewById(R.id.ec12);

    sc11 = (EditText) findViewById(R.id.sc11);
    sc12 = (EditText) findViewById(R.id.sc12);

    tv11 = (TextView) findViewById(R.id.tc11);
    bc11 = (Button) findViewById(R.id.bc11);

    bc11.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });
  }
}
