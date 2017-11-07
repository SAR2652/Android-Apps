package com.sarveshrelekar.happy_birthday;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    boolean isPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer hb = MediaPlayer.create(MainActivity.this,R.raw.hb);
        final Button playPause = (Button) findViewById(R.id.play_pause);
        final Button ResetBtn = (Button) findViewById(R.id.reset);
        playPause.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if (isPlaying)
                {
                    pause(hb);
                }
                else
                {
                    play(hb);
                }
                isPlaying = !isPlaying;
            }
        });

        ResetBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                stop_reset(hb);
            }
        });
    }


    private void stop_reset(MediaPlayer hb)
    {
        hb.stop();
    }

    private void play(MediaPlayer hb)

    {
        hb.start();
    }

    private void pause(MediaPlayer hb)
    {
        hb.pause();
    }

}
