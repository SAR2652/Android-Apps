package com.sarveshrelekar.happy_birthday;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    boolean isPlaying = false; //Set condition for start
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //MediaPlayer Object is declared as final because onClick methods  that access MediaPlayer object are internal
        final MediaPlayer hb = MediaPlayer.create(MainActivity.this,R.raw.hb);
        
        //Adds PLAY / PAUSE Button
        final Button playPause = (Button) findViewById(R.id.play_pause);
        
        //Adds RESET Button
        final Button ResetBtn = (Button) findViewById(R.id.reset);
        
        //Play and Pause Button Event Handling
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
                isPlaying = !isPlaying;  //Change for next option call from say "Start" to "Pause"
            }
        });
        
        //Reset Button Event Handling
        ResetBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                stop_reset(hb);
            }
        });
        
        //Declare Videoview object 
        final VideoView video = (VideoView) findViewById(R.id.video);
        
        //Parsing object for Videoview 
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        
        //Set Parsing object for VideoView object video
        video.setVideoURI(uri);
        
        //Start Video
        video.start();
        
        //On video completion replay video
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            public void onCompletion(MediaPlayer mp)
            {
                video.start();
            }
        });
    }

    //reset method
    private void stop_reset(MediaPlayer hb)
    {
        hb.stop();                                 //Changes state of MediaPlayer object to 'Stopped"
        hb.prepareAsync();                         //prepares for Asynchronous startup
                                                   //(Object status changes from "Stopped' to "Prepared")
        isPlaying = false;                         //Provides condition for restarting song
    }
    
    //play method
    private void play(MediaPlayer hb)
    {
        hb.start();                                //Changes status of Mediaplayer object from "Idle"/"Prepared" to "Started"
    }
    
    //pause method
    private void pause(MediaPlayer hb)
    {
        hb.pause();                                //Changes status of MediaPlayer object from "Started" to "Paused"
    }
}
