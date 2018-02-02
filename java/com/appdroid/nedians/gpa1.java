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

public class gpa1 extends Activity
{
  Button bg11;
  EditText eg11,eg12;
  Spinner sg11,sg12;
  TextView tg11;

  public void Gpa() {
    double d1 = 0.0D, d2 = 0.0D;

    double i1 = 0, i2 = 0;

    try {
      d1 = Double.parseDouble(eg11.getText().toString());
      d2 = Double.parseDouble(eg12.getText().toString());

      try {
        i1 = Double.parseDouble(sg11.getSelectedItem().toString());
        i2 = Double.parseDouble(sg12.getSelectedItem().toString());

        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D)) {
          Toast.makeText(getApplicationContext(), "Enter Valid GPA", Toast.LENGTH_LONG).show();
        }
        else{
          double d8 = ((d1*i1)+(d2*i2))/(i1+i2);
          String str = new DecimalFormat("#.##").format(d8);
          tg11.setText("GPA = " + str);
        }

      } catch (Exception localException2) {
        Toast.makeText(getApplicationContext(), "Enter Credit Hours", Toast.LENGTH_LONG).show();
      }

    } catch (Exception localException1) {
      Toast.makeText(getApplicationContext(), "Enter valid Number", Toast.LENGTH_LONG).show();
    }
    this.eg11.setText("");
    this.eg12.setText("");
     }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gpa_1);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    eg11 = (EditText) findViewById(R.id.eg11);
    eg12 = (EditText) findViewById(R.id.eg12);

    sg11 = (Spinner) findViewById(R.id.sg11);
    sg12 = (Spinner) findViewById(R.id.sg12);

    tg11 = (TextView) findViewById(R.id.tg11);

    bg11 = (Button) findViewById(R.id.bg11);

    bg11.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Gpa();
      }
    });
  }
}



