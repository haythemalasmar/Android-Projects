package com.example.simplelistviewwithadditems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val names = arrayListOf<String>();
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
        listView.adapter = myAdapter;

        addButton.setOnClickListener {
            if (addInput.text.toString() == "") return@setOnClickListener;

            val name = addInput.text.toString();
            names.add(name);
            myAdapter.notifyDataSetChanged();

            addInput.text = null;
        }
    }
}
