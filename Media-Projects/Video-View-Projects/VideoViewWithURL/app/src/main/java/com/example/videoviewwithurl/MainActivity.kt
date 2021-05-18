package com.example.videoviewwithurl

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView.setVideoURI(Uri.parse("https://github.com/shawqihatem/RevisionProjects/blob/main/Media%20Projects/Video%20View%20Projects/VideoViewWithRawFile/app/src/main/res/raw/video.mp4?raw=true"));
        val mediaController = MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}