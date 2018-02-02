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

public class gpa2 extends Activity
{
  Button bg21;
  EditText eg21,eg22,eg23;
  Spinner sg21,sg22,sg23;
  TextView tg21;

  public void Gpa() {
    double d1 = 0.0D, d2 = 0.0D, d3 = 0.0D;

    double i1 = 0, i2 = 0, i3 = 0;

    try {
      d1 = Double.parseDouble(this.eg21.getText().toString());
      d2 = Double.parseDouble(this.eg22.getText().toString());
      d3 = Double.parseDouble(this.eg23.getText().toString());

      try {
        i1 = Double.parseDouble(this.sg21.getSelectedItem().toString());
        i2 = Double.parseDouble(this.sg22.getSelectedItem().toString());
        i3 = Double.parseDouble(this.sg23.getSelectedItem().toString());

        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D)) {
          Toast.makeText(getApplicationContext(), "Enter Valid GPA", Toast.LENGTH_LONG).show();
        } else {
          double d8 = ((d1 * i1) + (d2 * i2) + (d3 * i3)) / (i1 + i2 + i3);
          DecimalFormat DecimalFormat = new DecimalFormat("0.00");
          String str = new DecimalFormat("#.##").format(d8);
          tg21.setText("GPA = " + str);
        }
      } catch (Exception localException2) {
        Toast.makeText(getApplicationContext(), "Enter Credit Hours", Toast.LENGTH_LONG).show();
      }

    } catch (Exception localException1) {
      Toast.makeText(getApplicationContext(), "Enter valid Number", Toast.LENGTH_LONG).show();
    }
    this.eg21.setText("");
    this.eg22.setText("");
    this.eg23.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gpa_2);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    eg21 = (EditText) findViewById(R.id.eg21);
    eg22 = (EditText) findViewById(R.id.eg22);
    eg23 = (EditText) findViewById(R.id.eg23);

    sg21 = (Spinner) findViewById(R.id.sg21);
    sg22 = (Spinner) findViewById(R.id.sg22);
    sg23 = (Spinner) findViewById(R.id.sg23);
    tg21 = (TextView) findViewById(R.id.tg21);
    bg21 = (Button) findViewById(R.id.bg21);

    bg21.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Gpa();
      }
    });
  }
}



