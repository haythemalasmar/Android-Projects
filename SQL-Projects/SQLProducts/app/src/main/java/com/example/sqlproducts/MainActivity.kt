package com.example.sqlproducts

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.view.*

class MainActivity : AppCompatActivity() {
    lateinit var myDatabase: MyDatabase;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = MyDatabase(this);

        productsListButton.setOnClickListener {
            val intent = Intent(this, ProductsActivity::class.java);
            startActivity(intent);
        }
    }

    fun addProduct(view: View) {
        if (nameInput.text.toString() == "" || quantityInput.text.toString() == "") return;

        val productName = nameInput.text.toString();
        val productQuantity = quantityInput.text.toString().toInt();
        myDatabase.addProduct(MyDatabase.PRODUCT_NAME, productName, MyDatabase.PRODUCT_QUANTITY, productQuantity);

        nameInput.text = null;
        quantityInput.text = null;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteProduct(view: View) {
        val layoutInflater = LayoutInflater.from(this);
        val view = layoutInflater.inflate(R.layout.dialog, null);

        val dialogBuilder = AlertDialog.Builder(this);
        dialogBuilder.setView(view);

        val dialog = dialogBuilder.create();
        dialog.show();

        view.deleteButton.setOnClickListener {
            if (view.idInput.text.toString() == "") return@setOnClickListener;

            val productID = view.idInput.text.toString().toInt();
            myDatabase.deleteProduct(productID);
            showNotification("Product Deleted", "You have deleted the product with the id $productID")
            dialog.cancel();
        }

        view.cancelButton.setOnClickListener {
            dialog.cancel();
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun showNotification(title: String, text: String) {
        val CHANNEL_ID = "DELETED_PRODUCTS_CHANNEL";
        val ID = 2222;

        val importance = NotificationManager.IMPORTANCE_HIGH;
        val myChannel = NotificationChannel(CHANNEL_ID, "Deleting Notification Channel", importance);
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(title)
                .setContentText(text)
                .build();

        val intent = Intent(this, ProductsActivity::class.java);
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.contentIntent = pendingIntent;

        val myNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        myNotificationManager.createNotificationChannel(myChannel);
        myNotificationManager.notify(ID, notification);
    }
}