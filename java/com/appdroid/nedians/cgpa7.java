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

public class cgpa7 extends Activity
{
  Button bc71;
  EditText ec71,ec72,ec73,ec74,ec75,ec76,ec77,ec78,sc71,sc72,sc73,sc74,sc75,sc76,sc77,sc78;
  TextView tv71;
  
  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D,d6 = 0.0D,d7 = 0.0D,d8 = 0.0D,d9 = 0.0D,d10 = 0.0D,d11 = 0.0D,d12 = 0.0D,d13 = 0.0D,d14 = 0.0D,d15 = 0.0D,d16 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec71.getText().toString());
      d2 = Double.parseDouble(this.ec72.getText().toString());
      d3 = Double.parseDouble(this.ec73.getText().toString());
      d4 = Double.parseDouble(this.ec74.getText().toString());
      d5 = Double.parseDouble(this.ec75.getText().toString());
      d6 = Double.parseDouble(this.ec76.getText().toString());
      d7 = Double.parseDouble(this.ec77.getText().toString());
      d8 = Double.parseDouble(this.ec78.getText().toString());

      d9  = Double.parseDouble(this.sc71.getText().toString());
      d10 = Double.parseDouble(this.sc72.getText().toString());
      d11 = Double.parseDouble(this.sc73.getText().toString());
      d12 = Double.parseDouble(this.sc74.getText().toString());
      d13 = Double.parseDouble(this.sc75.getText().toString());
      d14 = Double.parseDouble(this.sc76.getText().toString());
      d15 = Double.parseDouble(this.sc77.getText().toString());
      d16 = Double.parseDouble(this.sc78.getText().toString());

      if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D) || (d6 < 1.0D) || (d6 > 4.0D) || (d7 < 1.0D) || (d7 > 4.0D) || (d8 < 1.0D) || (d8 > 4.0D))
      {
        Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
      }
      else{
        double d17 = ((d1 * d9) + (d2 * d10) + (d3 * d11) + (d4 * d12) + (d5 * d13) + (d6 * d14) + (d7 * d15) + (d8 * d16)) / (d16 + d15 + d14 + d13 + d12 + d11 + d10 + d9);
        String str = new DecimalFormat("#.##").format(d17);
        tv71.setText("CGPA = " + str);
      }


    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec71.setText("");
    ec72.setText("");
    ec73.setText("");
    ec74.setText("");
    ec75.setText("");
    ec76.setText("");
    ec77.setText("");
    ec78.setText("");
    sc71.setText("");
    sc72.setText("");
    sc73.setText("");
    sc74.setText("");
    sc75.setText("");
    sc76.setText("");
    sc77.setText("");
    sc78.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_7);

    ec71 = (EditText) findViewById(R.id.ec71);
    ec72 = (EditText) findViewById(R.id.ec72);
    ec73 = (EditText) findViewById(R.id.ec73);
    ec74 = (EditText) findViewById(R.id.ec74);
    ec75 = (EditText) findViewById(R.id.ec75);
    ec76 = (EditText) findViewById(R.id.ec76);
    ec77 = (EditText) findViewById(R.id.ec77);
    ec78 = (EditText) findViewById(R.id.ec78);

    sc71 = (EditText) findViewById(R.id.sc71);
    sc72 = (EditText) findViewById(R.id.sc72);
    sc73 = (EditText) findViewById(R.id.sc73);
    sc74 = (EditText) findViewById(R.id.sc74);
    sc75 = (EditText) findViewById(R.id.sc75);
    sc76 = (EditText) findViewById(R.id.sc76);
    sc77 = (EditText) findViewById(R.id.sc77);
    sc78 = (EditText) findViewById(R.id.sc78);

    tv71 = (TextView) findViewById(R.id.tc71);
    bc71 = (Button) findViewById(R.id.bc71);

    bc71.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });


    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

  }
}
