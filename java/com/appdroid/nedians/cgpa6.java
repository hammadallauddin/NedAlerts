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

public class cgpa6 extends Activity
{
  Button bc61;
  EditText ec61,ec62,ec63,ec64,ec65,ec66,ec67,sc61,sc62,sc63,sc64,sc65,sc66,sc67;
  TextView tv61;

  public void Calculation()
  {
    double d1 = 0.0D,d2 = 0.0D,d3 = 0.0D,d4 = 0.0D,d5 = 0.0D,d6 = 0.0D,d7 = 0.0D,d9 = 0.0D,d10 = 0.0D,d11 = 0.0D,d12 = 0.0D,d13 = 0.0D,d14 = 0.0D,d15 = 0.0D;
    try
    {
      d1 = Double.parseDouble(this.ec61.getText().toString());
      d2 = Double.parseDouble(this.ec62.getText().toString());
      d3 = Double.parseDouble(this.ec63.getText().toString());
      d4 = Double.parseDouble(this.ec64.getText().toString());
      d5 = Double.parseDouble(this.ec65.getText().toString());
      d6 = Double.parseDouble(this.ec66.getText().toString());
      d7 = Double.parseDouble(this.ec67.getText().toString());


      d9  = Double.parseDouble(this.sc61.getText().toString());
      d10 = Double.parseDouble(this.sc62.getText().toString());
      d11 = Double.parseDouble(this.sc63.getText().toString());
      d12 = Double.parseDouble(this.sc64.getText().toString());
      d13 = Double.parseDouble(this.sc65.getText().toString());
      d14 = Double.parseDouble(this.sc66.getText().toString());
      d15 = Double.parseDouble(this.sc67.getText().toString());

      if ((d1 < 1.0D) || (d1 > 4.0D) || (d2 < 1.0D) || (d2 > 4.0D) || (d3 < 1.0D) || (d3 > 4.0D) || (d4 < 1.0D) || (d4 > 4.0D) || (d5 < 1.0D) || (d5 > 4.0D) || (d6 < 1.0D) || (d6 > 4.0D) || (d7 < 1.0D) || (d7 > 4.0D))
      {
        Toast.makeText(getApplicationContext(), "Enter valid GPA", Toast.LENGTH_LONG).show();
      }
      else{

        double d17 = ((d1 * d9) + (d2 * d10) + (d3 * d11) + (d4 * d12) + (d5 * d13) + (d6 * d14) + (d7 * d15)) / (d15 + d14 + d13 + d12 + d11 + d10 + d9);
        String str = new DecimalFormat("#.##").format(d17);
        tv61.setText("CGPA = " + str);
      }

    }
    catch (Exception localException) {
      Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
    }
    ec61.setText("");
    ec62.setText("");
    ec63.setText("");
    ec64.setText("");
    ec65.setText("");
    ec66.setText("");
    ec67.setText("");

    sc61.setText("");
    sc62.setText("");
    sc63.setText("");
    sc64.setText("");
    sc65.setText("");
    sc66.setText("");
    sc67.setText("");

  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cgpa_6);


    MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
    AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

    ec61 = (EditText) findViewById(R.id.ec61);
    ec62 = (EditText) findViewById(R.id.ec62);
    ec63 = (EditText) findViewById(R.id.ec63);
    ec64 = (EditText) findViewById(R.id.ec64);
    ec65 = (EditText) findViewById(R.id.ec65);
    ec66 = (EditText) findViewById(R.id.ec66);
    ec67 = (EditText) findViewById(R.id.ec67);


    sc61 = (EditText) findViewById(R.id.sc61);
    sc62 = (EditText) findViewById(R.id.sc62);
    sc63 = (EditText) findViewById(R.id.sc63);
    sc64 = (EditText) findViewById(R.id.sc64);
    sc65 = (EditText) findViewById(R.id.sc65);
    sc66 = (EditText) findViewById(R.id.sc66);
    sc67 = (EditText) findViewById(R.id.sc67);

    tv61 = (TextView) findViewById(R.id.tc61);
    bc61 = (Button) findViewById(R.id.bc61);

    bc61.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Calculation();
      }
    });
  }
}
