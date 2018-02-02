package com.appdroid.nedians;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.os.StrictMode;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class MyService extends Service {
    NotificationCompat.Builder notification;
    NotificationCompat.Builder notificationn;
    NotificationCompat.Builder notificatione;
    int count = 0,saved = -1;
    String REF = "refrenced";
    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        new Thread(){
            @SuppressLint("WrongConstant")
            @Override
            public void run() {
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true)
                        .setOAuthConsumerKey("bbUSuoAATH9OdJtok7FnYS2wl")
                        .setOAuthConsumerSecret("R7RwhmLY2nONeXkzFUjppbKNyyS0inxqabwBrXGRqSACrqaEcP")
                        .setOAuthAccessToken("218180644-oHl0qndTr6oQ91csSCf1tHa4luLt87ipGerlFvzK")
                        .setOAuthAccessTokenSecret("E6XEBR2xxzAhGVqDot4quuRtvr322GtefbbWKcuv83KGh");
                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();
                try {
                    SharedPreferences prefs = getSharedPreferences(REF, Context.MODE_PRIVATE);
                    saved = prefs.getInt("count",-1);
                    User user = twitter.showUser("nsaneduet");
                    count = user.getStatusesCount();
                    if(count != saved ){
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("count",count);
                        editor.commit();

                        notification = new NotificationCompat.Builder(getApplicationContext());
                        notification.setAutoCancel(true);
                        notification.setSmallIcon(R.drawable.alert);
                        notification.setWhen(System.currentTimeMillis());
                        notification.setContentTitle("NED Alerts");
                        notification.setContentText("Check new Alert");
                        Uri localUri = RingtoneManager.getDefaultUri(2);
                        notification.setSound(localUri);
                        Intent localIntent = new Intent(MyService.this, Alerts.class);
                        TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(getApplicationContext());
                        localTaskStackBuilder.addParentStack(Menu.class);
                        localTaskStackBuilder.addNextIntent(localIntent);
                        PendingIntent localPendingIntent = localTaskStackBuilder.getPendingIntent(0, 579567);
                        notification.setContentIntent(localPendingIntent);
                        ((NotificationManager)getSystemService("notification")).notify(883221,notification.build());
                    }
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        new Thread(){
            @SuppressLint("WrongConstant")
            @Override
            public void run() {
                String ss,s;
                ArrayList<String> eve = new ArrayList<String>();
                Document d = null;
                SharedPreferences events = getSharedPreferences("EVENTS", Context.MODE_PRIVATE);
                ss = events.getString("EVENT", "nothing");
                try {
                    d = Jsoup.connect("http://www.neduet.edu.pk/news_events/events.html").get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    d = Jsoup.connect("http://www.neduet.edu.pk/news_events/events.html").get();
                    Elements body = d.select("div#whats-happening-scroller > table > tbody");

                    for(Element rows:body.select("tr")){
                        Elements td = rows.select("td");
                        if(!(td.text().equals(""))){
                            eve.add(td.text());
                            }
                        }
                        s = eve.get(1);

                        if(!(s.equals(ss))){
                            SharedPreferences.Editor editor = events.edit();
                            editor.putString("EVENT",s);
                            editor.commit();

                            notificatione = new NotificationCompat.Builder(getApplicationContext());
                            notificatione.setAutoCancel(true);
                            notificatione.setSmallIcon(R.drawable.events);
                            notificatione.setWhen(System.currentTimeMillis());
                            notificatione.setContentTitle("NED Event Alerts");
                            notificatione.setContentText("Check new Event Alert");
                            Uri localUri = RingtoneManager.getDefaultUri(2);
                            notificatione.setSound(localUri);
                            Intent localIntent = new Intent(MyService.this, Events.class);
                            TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(getApplicationContext());
                            localTaskStackBuilder.addParentStack(Menu.class);
                            localTaskStackBuilder.addNextIntent(localIntent);
                            PendingIntent localPendingIntent = localTaskStackBuilder.getPendingIntent(0, 12345);
                            notificatione.setContentIntent(localPendingIntent);
                            ((NotificationManager)getSystemService("notification")).notify(67890,notificatione.build());
                        }
                    }
                    catch (Exception e){
                    }

            }
        }.start();

        new Thread(){
            @SuppressLint("WrongConstant")
            @Override
            public void run() {
                String snn,sn;
                ArrayList<String> ne = new ArrayList<String>();
                Document dn = null;
                SharedPreferences newss = getSharedPreferences("NEWSS", Context.MODE_PRIVATE);
                snn = newss.getString("NEWS", "nothing");
                try {
                    dn = Jsoup.connect("http://www.neduet.edu.pk/news_events/news.html").get();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    dn = Jsoup.connect("http://www.neduet.edu.pk/news_events/news.html").get();
                    Elements body = dn.select("div#whats-happening-scroller > table > tbody");

                    for(Element rows:body.select("tr")){
                        Elements td = rows.select("td");
                        if(!(td.text().equals(""))){
                            ne.add(td.text());
                            }
                        }
                        sn = ne.get(1);
                    if (!(sn.equals(snn))) {
                        SharedPreferences.Editor editor = newss.edit();
                        editor.putString("NEWS", sn);
                        editor.commit();

                        notificationn = new NotificationCompat.Builder(getApplicationContext());
                        notificationn.setAutoCancel(true);
                        notificationn.setSmallIcon(R.drawable.news);
                        notificationn.setWhen(System.currentTimeMillis());
                        notificationn.setContentTitle("NED News Alerts");
                        notificationn.setContentText("Check new News Alert");
                        Uri localUri = RingtoneManager.getDefaultUri(2);
                        notificationn.setSound(localUri);
                        Intent localIntent = new Intent(MyService.this, News.class);
                        TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(getApplicationContext());
                        localTaskStackBuilder.addParentStack(News.class);
                        localTaskStackBuilder.addNextIntent(localIntent);
                        PendingIntent localPendingIntent = localTaskStackBuilder.getPendingIntent(0, 54321);
                        notificationn.setContentIntent(localPendingIntent);
                        ((NotificationManager) getSystemService("notification")).notify(98765, notificationn.build());
                    }
                }
                catch(Exception e){
                }
            }
        }.start();


        return START_STICKY;
    }
}
