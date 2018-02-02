package com.appdroid.nedians;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class VisitWeb extends AppCompatActivity {
    WebView wv01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visit_web);

        Toast.makeText(getApplicationContext(), "Connecting",Toast.LENGTH_LONG).show();
        wv01 = ((WebView)findViewById(R.id.wv01));
        wv01.loadUrl("http://www.neduet.edu.pk/");
        wv01.getSettings().setBuiltInZoomControls(true);
        WebSettings localWebSettings = wv01.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setSupportZoom(true);
        localWebSettings.setDisplayZoomControls(true);
        wv01.setWebViewClient(new WebViewClient());

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}
