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

public class gpa6 extends Activity
{
  Button bg61;
  EditText eg61,eg62,eg63,eg64,eg65,eg66,eg67;
  Spinner sg61,sg62,sg63,sg64,sg65,sg66,sg67;
  TextView tg61;
  
  public void Gpa()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D,d6 = 0.0D,d7 = 0.0D;

    double i1 = 0,i2 = 0,i3 = 0,i4 = 0,i5 = 0,i6 = 0,i7=0;

    try
    {
      d1 = Double.parseDouble(this.eg61.getText().toString());
      d2 = Double.parseDouble(this.eg62.getText().toString());
      d3 = Double.parseDouble(this.eg63.getText().toString());
      d4 = Double.parseDouble(this.eg64.getText().toString());
      d5 = Double.parseDouble(this.eg65.getText().toString());
      d6 = Double.parseDouble(this.eg66.getText().toString());
      d7 = Double.parseDouble(this.eg67.getText().toString());

      try
      {
        i1 = Double.parseDouble(sg61.getSelectedItem().toString());
        i2 = Double.parseDouble(sg62.getSelectedItem().toString());
        i3 = Double.parseDouble(sg63.getSelectedItem().toString());
        i4 = Double.parseDouble(sg64.getSelectedItem().toString());
        i5 = Double.parseDouble(sg65.getSelectedItem().toString());
        i6 = Double.parseDouble(sg66.getSelectedItem().toString());
        i7 = Double.parseDouble(sg67.getSelectedItem().toString());

        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D) || (d6 < 1.0D) || (d6 > 4.0D) || (d7 < 1.0D) || (d7 > 4.0D))
        {
          Toast.makeText(getApplicationContext(), "Enter Valid GPA", Toast.LENGTH_LONG).show();
        }
        else{
          double d8 = ((d1 * i1) + (d2 * i2) + (d3 * i3) + (d4 * i4) + (d5 * i5) + (d6 * i6) + (d7 * i7)) / (i1 + i2 + i3 + i4 + i5 + i6 + i7);
          DecimalFormat DecimalFormat = new DecimalFormat("0.00");
          String str = new DecimalFormat("#.##").format(d8);
          tg61.setText("GPA = " + str);
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
    this.eg61.setText("");
    this.eg62.setText("");
    this.eg63.setText("");
    this.eg64.setText("");
    this.eg65.setText("");
    this.eg66.setText("");
    this.eg67.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gpa_6);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    eg61 = (EditText) findViewById(R.id.eg61);
    eg62 = (EditText) findViewById(R.id.eg62);
    eg63 = (EditText) findViewById(R.id.eg63);
    eg64 = (EditText) findViewById(R.id.eg64);
    eg65 = (EditText) findViewById(R.id.eg65);
    eg66 = (EditText) findViewById(R.id.eg66);
    eg67 = (EditText) findViewById(R.id.eg67);

    sg61 = (Spinner) findViewById(R.id.sg61);
    sg62 = (Spinner) findViewById(R.id.sg62);
    sg63 = (Spinner) findViewById(R.id.sg63);
    sg64 = (Spinner) findViewById(R.id.sg64);
    sg65 = (Spinner) findViewById(R.id.sg65);
    sg66 = (Spinner) findViewById(R.id.sg66);
    sg67 = (Spinner) findViewById(R.id.sg67);
    tg61 = (TextView) findViewById(R.id.tg61);
    bg61 = (Button) findViewById(R.id.bg61);

    bg61.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Gpa();
      }
    });
  }
}



