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

public class cgpa5 extends Activity
{
  Button bc51;
  EditText ec51,ec52,ec53,ec54,ec55,ec56,sc51,sc52,sc53,sc54,sc55,sc56;
  TextView tv51;

  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D,d6 = 0.0D,d9 = 0.0D,d10 = 0.0D,d11 = 0.0D,d12 = 0.0D,d13 = 0.0D,d14 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec51.getText().toString());
      d2 = Double.parseDouble(this.ec52.getText().toString());
      d3 = Double.parseDouble(this.ec53.getText().toString());
      d4 = Double.parseDouble(this.ec54.getText().toString());
      d5 = Double.parseDouble(this.ec55.getText().toString());
      d6 = Double.parseDouble(this.ec56.getText().toString());


      d9  = Double.parseDouble(this.sc51.getText().toString());
      d10 = Double.parseDouble(this.sc52.getText().toString());
      d11 = Double.parseDouble(this.sc53.getText().toString());
      d12 = Double.parseDouble(this.sc54.getText().toString());
      d13 = Double.parseDouble(this.sc55.getText().toString());
      d14 = Double.parseDouble(this.sc56.getText().toString());

      if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D) || (d6 < 1.0D) || (d6 > 4.0D))
      {
        Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
      }
      else {
        double d17 = ((d1 * d9) + (d2 * d10) + (d3 * d11) + (d4 * d12) + (d5 * d13) + (d6 * d14)) / ( d14 + d13 + d12 + d11 + d10 + d9);
        String str = new DecimalFormat("#.##").format(d17);
        tv51.setText("CGPA = " + str);
      }

    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec51.setText("");
    ec52.setText("");
    ec53.setText("");
    ec54.setText("");
    ec55.setText("");
    ec56.setText("");

    sc51.setText("");
    sc52.setText("");
    sc53.setText("");
    sc54.setText("");
    sc55.setText("");
    sc56.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_5);


    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    ec51 = (EditText) findViewById(R.id.ec51);
    ec52 = (EditText) findViewById(R.id.ec52);
    ec53 = (EditText) findViewById(R.id.ec53);
    ec54 = (EditText) findViewById(R.id.ec54);
    ec55 = (EditText) findViewById(R.id.ec55);
    ec56 = (EditText) findViewById(R.id.ec56);


    sc51 = (EditText) findViewById(R.id.sc51);
    sc52 = (EditText) findViewById(R.id.sc52);
    sc53 = (EditText) findViewById(R.id.sc53);
    sc54 = (EditText) findViewById(R.id.sc54);
    sc55 = (EditText) findViewById(R.id.sc55);
    sc56 = (EditText) findViewById(R.id.sc56);

    tv51 = (TextView) findViewById(R.id.tc51);
    bc51 = (Button) findViewById(R.id.bc51);

    bc51.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });
  }
}
