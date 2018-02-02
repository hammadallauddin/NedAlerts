package com.appdroid.nedians;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;
import io.fabric.sdk.android.Fabric;

public class Alerts extends ListActivity {
    ProgressBar pb;
    Runnable r;
    Thread t;
    AdView mAdView; AdRequest adRequest;
    TweetTimelineListAdapter adapter;
    private SwipeRefreshLayout swipeContainer;


    private static final String TWITTER_KEY = "5U51PaR5VI7Cu29xFvvhpIp6v";
    private static final String TWITTER_SECRET = "yeA32CU14DvVHtOavOLMSbKCr8oDrooSOcpdLXltRvxXLMBkcs";


    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg){
            mAdView.loadAd(adRequest);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerts);
        mAdView = (AdView) findViewById(R.id.adView);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        pb = (ProgressBar) findViewById(R.id.progressBar2);
        pb.getIndeterminateDrawable().setColorFilter(Color.parseColor("#3090C7"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        Toast.makeText(getApplicationContext(),"Loading..", Toast.LENGTH_LONG).show();



        Thread t = new Thread() {
            @Override
            public void run(){
                MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
                adRequest = new AdRequest.Builder().build();
                h.sendEmptyMessage(0);
            }
        };
        t.start();

        new showAlert().doInBackground();

        swipeContainer.setColorSchemeColors(Color.parseColor("#3090C7"));
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new showAlert().doInBackground();
                swipeContainer.setRefreshing(false);
                Toast.makeText(getApplicationContext(),"Refreshing..", Toast.LENGTH_SHORT).show();
            }
        });

    }


    class showAlert extends AsyncTask<Void,Void,Void> {
        int size = 0;
        @Override
        protected Void doInBackground(Void... params) {
            try{
                TwitterAuthConfig localTwitterAuthConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
                Fabric.with(Alerts.this, new Twitter(localTwitterAuthConfig));
                final UserTimeline userTimeline = new UserTimeline.Builder().screenName("nsaneduet").build();
                adapter = new TweetTimelineListAdapter.Builder(Alerts.this)
                        .setTimeline(userTimeline)
                        .build();
                adapter.notifyDataSetChanged();
                setListAdapter(adapter);
                swipeContainer.setRefreshing(false);
            }catch (Exception e){
                cancel(true);
            }
            return  null;
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getApplicationContext(),"Error while loading",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Alerts.this,Menu.class));
        }

    }

}