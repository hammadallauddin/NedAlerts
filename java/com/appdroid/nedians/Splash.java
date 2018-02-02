package com.appdroid.nedians;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.getIndeterminateDrawable().setColorFilter(Color.parseColor("#3090C7"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000L);
                    Splash.this.startActivity(new Intent(Splash.this, Menu.class));
                    Splash.this.finish();
                    return;
                }
                catch (InterruptedException localInterruptedException)
                {
                    localInterruptedException.printStackTrace();
                }
            }
        }.start();

    }
}
