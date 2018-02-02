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

public class gpa4 extends Activity
{
  Button bg41;
  EditText eg41,eg42,eg43,eg44,eg45;
  Spinner sg41,sg42,sg43,sg44,sg45;
  TextView tg41;

  public void Gpa()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D;

    double i1 = 0,i2 = 0,i3 = 0,i4 = 0,i5 = 0;

    try
    {
      d1 = Double.parseDouble(this.eg41.getText().toString());
      d2 = Double.parseDouble(this.eg42.getText().toString());
      d3 = Double.parseDouble(this.eg43.getText().toString());
      d4 = Double.parseDouble(this.eg44.getText().toString());
      d5 = Double.parseDouble(this.eg45.getText().toString());

      try
      {
        i1 = Double.parseDouble(this.sg41.getSelectedItem().toString());
        i2 = Double.parseDouble(this.sg42.getSelectedItem().toString());
        i3 = Double.parseDouble(this.sg43.getSelectedItem().toString());
        i4 = Double.parseDouble(this.sg44.getSelectedItem().toString());
        i5 = Double.parseDouble(this.sg45.getSelectedItem().toString());

        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D))
        {
          Toast.makeText(getApplicationContext(), "Enter Valid GPA", Toast.LENGTH_LONG).show();
        }
        else{
          double d8 = ((d1 * i1) + (d2 * i2) + (d3 * i3) + (d4 * i4) + (d5 * i5)) / (i1 + i2 + i3 + i4 + i5);
          DecimalFormat DecimalFormat = new DecimalFormat("0.00");
          String str = new DecimalFormat("#.##").format(d8);
          tg41.setText("GPA = " + str);
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
    this.eg41.setText("");
    this.eg42.setText("");
    this.eg43.setText("");
    this.eg44.setText("");
    this.eg45.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gpa_4);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    eg41 = (EditText) findViewById(R.id.eg41);
    eg42 = (EditText) findViewById(R.id.eg42);
    eg43 = (EditText) findViewById(R.id.eg43);
    eg44 = (EditText) findViewById(R.id.eg44);
    eg45 = (EditText) findViewById(R.id.eg45);

    sg41 = (Spinner) findViewById(R.id.sg41);
    sg42 = (Spinner) findViewById(R.id.sg42);
    sg43 = (Spinner) findViewById(R.id.sg43);
    sg44 = (Spinner) findViewById(R.id.sg44);
    sg45 = (Spinner) findViewById(R.id.sg45);
    tg41 = (TextView) findViewById(R.id.tg41);
    bg41 = (Button) findViewById(R.id.bg41);

    bg41.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Gpa();
      }
    });
  }
}



