package com.example.customlistviewwithadditems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val names = arrayListOf<String>();
        val images = arrayListOf<Int>();
        val myAdapter = CustomAdapter(this, names, images);
        listView.adapter = myAdapter;

        addButton.setOnClickListener {
            if (addInput.text.toString() == "") return@setOnClickListener;

            val name = addInput.text.toString();
            names.add(name);
            images.add(R.drawable.first);
            myAdapter.notifyDataSetChanged();

            addInput.text = null;
        }
    }
}
