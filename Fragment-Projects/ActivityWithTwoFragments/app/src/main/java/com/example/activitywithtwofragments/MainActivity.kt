package com.example.activitywithtwofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, FirstFragment())
                .commit();
        }

        secondFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, SecondFragment())
                .commit();
        }
    }
}