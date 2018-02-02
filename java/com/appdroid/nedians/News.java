package com.appdroid.nedians;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class News extends AppCompatActivity {

    ProgressBar npb;
    ListView nlv;
    ArrayList<String> temp =  new ArrayList<>();
    ArrayList<String> list =  new ArrayList<>();
    ArrayList<String> list2 =  new ArrayList<>();
    NewsAdapter adapter;
    AdView mAdView; AdRequest adRequest;


    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg){
            mAdView.loadAd(adRequest);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        mAdView = (AdView) findViewById(R.id.adView);
        nlv = (ListView) findViewById(R.id.nlv);
        npb = (ProgressBar) findViewById(R.id.npe);
        npb.getIndeterminateDrawable().setColorFilter(Color.parseColor("#3090C7"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        Toast.makeText(getApplicationContext(),"Loading..", Toast.LENGTH_SHORT).show();

        new news().execute();

        Thread t = new Thread() {
            @Override
            public void run(){
                MobileAds.initialize(getApplicationContext(), "ca-app-pub-5691018423026928/6776225493");
                adRequest = new AdRequest.Builder().build();
                new news().execute();
                h.sendEmptyMessage(0);
            }
        };
        t.start();
    }

    class news extends AsyncTask<Void,Void,Void> {
        String s;
        @Override
        protected Void doInBackground(Void... params) {
            Document dd = null;
            try {
                dd = Jsoup.connect("http://www.neduet.edu.pk/news_events/news.html").get();
                Elements body = dd.select("div#whats-happening-scroller > table > tbody");

                for(Element rows:body.select("tr")){
                    Elements td = rows.select("td");
                    if(!(td.text().equals(""))){
                        temp.add(td.text());
                    }
                }

                list.add(temp.get(0));list2.add(temp.get(1));
                list.add(temp.get(2));list2.add(temp.get(3));
                list.add(temp.get(4));list2.add(temp.get(5));
                list.add(temp.get(6));list2.add(temp.get(7));
                list.add(temp.get(8));list2.add(temp.get(9));
                list.add(temp.get(10));list2.add(temp.get(11));
            }
            catch (IOException e) {
                e.printStackTrace();
                cancel(true);
            }
            return null;
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(getApplicationContext(),"Error while loading",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(News.this,Menu.class));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if(list.isEmpty()==true || list2.isEmpty()==true){
                Toast.makeText(getApplicationContext(),"Error while loading",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(News.this,Menu.class));
            }
            else{
                adapter = new NewsAdapter(getApplicationContext(),list, list2);
                nlv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                npb.setVisibility(View.INVISIBLE);
            }
            super.onPostExecute(aVoid);
        }
    }
}
