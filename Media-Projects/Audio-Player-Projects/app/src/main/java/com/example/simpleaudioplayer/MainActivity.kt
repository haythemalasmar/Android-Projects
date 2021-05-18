package com.example.simpleaudioplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        val mediaPlayer = MediaPlayer();
        var isPlay = true;

        playButton.setOnClickListener {
            if (isPlay) {
                mediaPlayer.reset();
                mediaPlayer.setDataSource("android.resource://${packageName}/${R.raw.music}");
                mediaPlayer.prepare();
                mediaPlayer.start();
                playButton.text = "Stop";
            }

            if (!isPlay) {
                mediaPlayer.stop();
                playButton.text = "Play";
            }

            isPlay = !isPlay;
        }
    }
}