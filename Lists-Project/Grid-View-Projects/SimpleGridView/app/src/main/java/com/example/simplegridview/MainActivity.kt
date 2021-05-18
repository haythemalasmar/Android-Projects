package com.example.simplegridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val names = arrayOf("First Name", "Second Name", "Third Name", "Fourth Name");
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
        gridView.adapter = myAdapter;

        gridView.setOnItemClickListener { parent, view, position, id ->
            val itemContent = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, itemContent, Toast.LENGTH_LONG).show();
        }
    }
}