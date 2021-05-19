package com.example.horizontalscrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstImage.setImageResource(R.drawable.first);
        secondImage.setImageResource(R.drawable.second);
        thirdImage.setImageResource(R.drawable.third);
        fourthImage.setImageResource(R.drawable.fourth);
        fifthImage.setImageResource(R.drawable.fifth);
        sixthImage.setImageResource(R.drawable.sixth);
    }
}