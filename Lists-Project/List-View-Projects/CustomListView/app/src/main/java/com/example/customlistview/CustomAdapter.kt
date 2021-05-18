package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.custom_item.view.*

class CustomAdapter (context: Context,
                     private val names : Array<String>,
                     private val images : Array<Int>)
    : ArrayAdapter<String> (context, R.layout.custom_item, names) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater : LayoutInflater = LayoutInflater.from(context);
        val customView : View = layoutInflater.inflate(R.layout.custom_item, parent, false);

        customView.itemName.text = names[position!!];
        customView.itemImage.setImageResource(images[position!!]);

        return customView;
    }
}