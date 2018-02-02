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

public class gpa5 extends Activity
{
  Button bg51;
  EditText eg51,eg52,eg53,eg54,eg55,eg56;
  Spinner sg51,sg52,sg53,sg54,sg55,sg56;
  TextView tg51;

  public void Gpa()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D,d6 = 0.0D;

    double i1 = 0,i2 = 0,i3 = 0,i4 = 0,i5 = 0,i6 = 0;

    try
    {
      d1 = Double.parseDouble(this.eg51.getText().toString());
      d2 = Double.parseDouble(this.eg52.getText().toString());
      d3 = Double.parseDouble(this.eg53.getText().toString());
      d4 = Double.parseDouble(this.eg54.getText().toString());
      d5 = Double.parseDouble(this.eg55.getText().toString());
      d6 = Double.parseDouble(this.eg56.getText().toString());

      try
      {
        i1 = Double.parseDouble(this.sg51.getSelectedItem().toString());
        i2 = Double.parseDouble(this.sg52.getSelectedItem().toString());
        i3 = Double.parseDouble(this.sg53.getSelectedItem().toString());
        i4 = Double.parseDouble(this.sg54.getSelectedItem().toString());
        i5 = Double.parseDouble(this.sg55.getSelectedItem().toString());
        i6 = Double.parseDouble(this.sg56.getSelectedItem().toString());

        if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D) || (d6 < 1.0D) || (d6 > 4.0D))
        {
          Toast.makeText(getApplicationContext(), "Enter Valid GPA", Toast.LENGTH_LONG).show();
        }
        else{
          double d8 = ((d1 * i1) + (d2 * i2) + (d3 * i3) + (d4 * i4) + (d5 * i5) + (d6 * i6)) / (i1 + i2 + i3 + i4 + i5 + i6 );
          DecimalFormat DecimalFormat = new DecimalFormat("0.00");
          String str = new DecimalFormat("#.##").format(d8);
          tg51.setText("GPA = " + str);
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
    this.eg51.setText("");
    this.eg52.setText("");
    this.eg53.setText("");
    this.eg54.setText("");
    this.eg55.setText("");
    this.eg56.setText("");
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gpa_5);

    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    eg51 = (EditText) findViewById(R.id.eg51);
    eg52 = (EditText) findViewById(R.id.eg52);
    eg53 = (EditText) findViewById(R.id.eg53);
    eg54 = (EditText) findViewById(R.id.eg54);
    eg55 = (EditText) findViewById(R.id.eg55);
    eg56 = (EditText) findViewById(R.id.eg56);

    sg51 = (Spinner) findViewById(R.id.sg51);
    sg52 = (Spinner) findViewById(R.id.sg52);
    sg53 = (Spinner) findViewById(R.id.sg53);
    sg54 = (Spinner) findViewById(R.id.sg54);
    sg55 = (Spinner) findViewById(R.id.sg55);
    sg56 = (Spinner) findViewById(R.id.sg56);
    tg51 = (TextView) findViewById(R.id.tg51);
    bg51 = (Button) findViewById(R.id.bg51);

    bg51.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Gpa();
      }
    });
  }
}



