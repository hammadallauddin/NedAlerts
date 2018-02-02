package com.appdroid.nedians;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

public class gpa3 extends Activity
{
  Button bg31;
  EditText eg31,eg32,eg33,eg34;
  Spinner sg31,sg32,sg33,sg34;
  TextView tg31;

  public void Gpa()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D;

    double i1 = 0,i2 = 0,i3 = 0,i4 = 0;

    try
    {
      d1 = Double.parseDouble(this.eg31.getText().toString());
      d2 = Double.parseDouble(this.eg32.getText().toString());
      d3 = Double.parseDouble(this.eg33.getText().toString());
      d4 = Double.parseDouble(this.eg34.getText().toString());

      try
      {
        i1 = Double.parseDouble(this.sg31.getSelectedItem().toString());
        i2 = Double.parseDouble(this.sg32.getSelectedItem().toString());
        i3 = Double.parseDouble(this.sg33.getSelectedItem().toString());
        i4 = Double.parseDouble(this.sg34.getSelectedItem().toString());

        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D))
        {
          Toast.makeText(getApplicationContext(), "Enter Valid GPA", Toast.LENGTH_LONG).show();
        }
        else{
          double d8 = ((d1 * i1) + (d2 * i2) + (d3 * i3) + (d4 * i4)) / (i1 + i2 + i3 + i4);
          DecimalFormat DecimalFormat = new DecimalFormat("0.00");
          String str = new DecimalFormat("#.##").format(d8);
          tg31.setText("GPA = " + str);
        }
      }
      catch (Exception localException2)
      {
        Toast.makeText(getApplicationContext(), "Enter Credit Hours", Toast.LENGTH_LONG).show();
      }

    }
    catch (Exception localException1)
    {
      Toast.makeText(getApplicationContext(), "Enter valid Number", Toast.LENGTH_LONG).show();
    }
    this.eg31.setText("");
    this.eg32.setText("");
    this.eg33.setText("");
    this.eg34.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gpa_3);


    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);
    eg31 = (EditText) findViewById(R.id.eg31);
    eg32 = (EditText) findViewById(R.id.eg32);
    eg33 = (EditText) findViewById(R.id.eg33);
    eg34 = (EditText) findViewById(R.id.eg34);

    sg31 = (Spinner) findViewById(R.id.sg31);
    sg32 = (Spinner) findViewById(R.id.sg32);
    sg33 = (Spinner) findViewById(R.id.sg33);
    sg34 = (Spinner) findViewById(R.id.sg34);
    tg31 = (TextView) findViewById(R.id.tg31);
    bg31 = (Button) findViewById(R.id.bg31);

    bg31.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Gpa();
      }
    });
  }
}



