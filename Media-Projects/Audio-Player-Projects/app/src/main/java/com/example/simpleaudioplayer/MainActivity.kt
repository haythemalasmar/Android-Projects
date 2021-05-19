package com.example.simpleaudioplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        var mediaPlayer : MediaPlayer ? = null;

        playButton.setOnClickListener {
            if (mediaPlayer !== null) {
                mediaPlayer!!.start();
                return@setOnClickListener;
            }

            mediaPlayer = MediaPlayer.create(this, R.raw.music);
            mediaPlayer!!.isLooping = true;
            mediaPlayer!!.start();
        }

        pauseButton.setOnClickListener {
            if (mediaPlayer == null && !mediaPlayer!!.isPlaying) return@setOnClickListener;

            mediaPlayer!!.pause()
        }

        stopButton.setOnClickListener {
            if (mediaPlayer == null) return@setOnClickListener;

            mediaPlayer!!.stop();
            mediaPlayer!!.release();
            mediaPlayer = null;
        }
    }
}