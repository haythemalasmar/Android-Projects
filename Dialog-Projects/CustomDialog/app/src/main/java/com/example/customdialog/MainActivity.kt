package com.example.customdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val names = arrayListOf<String>();
        val myAdapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, names);
        listView.adapter = myAdapter;

        dialogButton.setOnClickListener {
            val layoutInflater = LayoutInflater.from(this);
            val view = layoutInflater.inflate(R.layout.dialog, null);

            val builder = AlertDialog.Builder(this);
            builder.setView(view);

            val dialog = builder.create();
            dialog.show();

            view.addButton.setOnClickListener {
                val name = view.dialogInput.text.toString();
                names.add(name);
                myAdapter.notifyDataSetChanged();
                dialog.cancel();
            }

            view.cancelButton.setOnClickListener {
                dialog.cancel();
            }
        }
    }
}