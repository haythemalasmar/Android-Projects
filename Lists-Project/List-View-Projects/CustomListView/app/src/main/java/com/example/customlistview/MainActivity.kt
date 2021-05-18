package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val names = arrayOf("First Item", "Second Item", "Third Item", "Fourth Item", "Fifth Item", "Sixth Item");
        val images = arrayOf(R.drawable.first, R.drawable.second, R.drawable.third, R.drawable.fourth, R.drawable.fifth, R.drawable.sixth);

        val myAdapter : CustomAdapter = CustomAdapter(this, names, images);
        listView.adapter = myAdapter;

        listView.setOnItemClickListener { parent, view, position, id ->
            val itemContent = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, itemContent, Toast.LENGTH_LONG).show();
        }
    }
}