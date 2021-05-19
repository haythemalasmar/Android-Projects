package com.example.simpledialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogButton.setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(this);
            dialogBuilder.setTitle("Warning");
            dialogBuilder.setMessage("Do you want to close the app?");

            dialogBuilder.setPositiveButton("Ok") { _ : DialogInterface, _ : Int ->
                finish();
            }

            dialogBuilder.setNegativeButton("Cancel") { _ : DialogInterface, _ : Int ->
            }

            val dialog = dialogBuilder.create();
            dialog.show();
        }
    }
}