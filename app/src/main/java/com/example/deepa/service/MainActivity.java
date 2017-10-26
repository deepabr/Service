package com.example.deepa.service;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.song);

        Button play, pause;
        play = (Button) findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Service.class);
                startService(i);
            }
        });
        pause = (Button) findViewById(R.id.button3);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                Intent i = new Intent(MainActivity.this, Service.class);
                stopService(i);
            }
        });
        // mp = MediaPlayer.create(getApplicationContext(), R.raw.song);
        final Button bt3 = (Button) findViewById(R.id.button4);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    bt3.setText("Play");
                } else {
                    mp.start();
                    bt3.setText("Pause");
                }
            }
        });
    }
}
