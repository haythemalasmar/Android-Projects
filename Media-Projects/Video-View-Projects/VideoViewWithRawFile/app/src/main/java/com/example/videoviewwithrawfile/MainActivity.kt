package com.example.videoviewwithrawfile

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView.setVideoURI(Uri.parse("android.resource://${packageName}/${R.raw.video}"));
        val mediaController = MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}