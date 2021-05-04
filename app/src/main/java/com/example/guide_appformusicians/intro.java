package com.example.guide_appformusicians;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.animation.AnimationUtils;

import java.util.Timer;
import java.util.TimerTask;

public class intro extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        timer =new Timer();
        timer.schedule(new TimerTask()  {

            @Override
            public void run() {
                Intent intent = new Intent(intro.this, Login.class);
                startActivity(intent);
                finish();

            }
        }, 8000);



    }
}